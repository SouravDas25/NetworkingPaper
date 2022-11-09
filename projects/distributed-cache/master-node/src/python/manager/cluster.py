from typing import Dict
from utils import CommonUtil
from lazy_streams import stream

from hasing import toCacheIndex


class Server:

    def __init__(self, serverName, serverUrl):
        self.serverName = serverName
        self.serverUrl = serverUrl
        self.cache = {}

    def moveKeys(self, targetServer, low: int, high: int, size: int):
        removeKeys = []
        for key in self.cache.keys():
            index = toCacheIndex(key, size)
            if low <= index < high:
                targetServer.put(key, self.cache[key])
                # self.cache.pop(key)
                removeKeys.append(key)
        stream(removeKeys).for_each(self.cache.pop)

    def size(self):
        return self.cache.__len__()

    def put(self, key, value):
        self.cache[key] = value

    def get(self, key):
        return self.cache[key]

    def has(self, key: str):
        return key in self.cache


class ServerCluster:

    def __init__(self, cacheSize):
        self.cacheSize = cacheSize
        self.servers: Dict[Server] = {}
        self.servePoints = []
        self.addServer("data-server-0", "", None, 0, cacheSize)
        # self.addServer("data-server-1", "")

    def balance(self):
        balanceREQ = []
        low = 0
        for serverIndex, serverId in self.servePoints:
            server = self.servers[serverId]
            capacity = serverIndex - low
            load = server.size() / capacity
            capacityPercent = capacity / self.cacheSize
            print(serverId, " : ", load, capacity, capacityPercent)
            if load > 0.5 and capacityPercent > 0.15:
                balanceREQ.append((serverId, low, serverIndex))
            low = serverIndex

        for serverId, low, high in balanceREQ:
            serverName = "data-server-" + str(len(self.servers))
            serverUrl = ""
            newHigh = low + (high - low) // 2
            # auto-scaling
            self.addServer(serverName, serverUrl, serverId, low, newHigh)
        pass

    def addServer(self, newServerId, serverUrl, overloadedServerId, low, high):
        self.servers[newServerId] = Server(newServerId, serverUrl)
        if overloadedServerId is not None:
            sourceServer: Server = self.servers[overloadedServerId]
            sourceServer.moveKeys(self.servers[newServerId], low, high, self.cacheSize)
        self.servePoints.append((high, newServerId))
        self.servePoints.sort()

    def removeServer(self, serverName):
        self.servers.pop(serverName)
        serverIndex = CommonUtil.findIndex(self.servePoints, lambda x: x[1] == serverName)
        if serverIndex is not None:
            del self.servePoints[serverIndex]

    def getServer(self, key) -> Server:
        serverName = self.resolveServer(key)
        return self.servers[serverName]

    def clusterSize(self):
        return len(self.servers)

    def resolveServer(self, key):
        keyIndex = toCacheIndex(key, self.cacheSize)
        for serverIndex, serverId in self.servePoints:
            if keyIndex <= serverIndex:
                return serverId
        return self.servePoints[0][1]


if __name__ == "__main__":
    import random
    import string


    def strGen(N):
        return ''.join(random.sample(string.ascii_uppercase + string.digits, N))


    sc = ServerCluster(10)
    for i in range(6):
        key = strGen(3)
        print("key ", key, toCacheIndex(key, 10))
        sc.getServer(key).put(key, i)

    stream(list(sc.servers.values())).for_each(lambda s: print(s.cache))
    sc.balance()
    print(sc.clusterSize(), sc.servePoints)
    stream(list(sc.servers.values())).for_each(lambda s: print(s.cache))
