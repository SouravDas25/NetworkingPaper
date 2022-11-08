from hasing import ConsistentHashing


class Server:

    def __init__(self, serverName, serverUrl):
        self.serverName = serverName
        self.serverUrl = serverUrl
        self.cache = {}

    def put(self, key, value):
        self.cache[key] = value

    def get(self, key):
        return self.cache[key]

    def has(self, key):
        return key in self.cache


class ServerCluster:

    def __init__(self, cacheSize):
        self.cacheSize = cacheSize
        self.servers = {}
        self.ch = ConsistentHashing(cacheSize)
        self.addServer("data-server-0", "")
        self.addServer("data-server-1", "")

    def addServer(self, serverName, serverUrl):
        self.servers[serverName] = Server(serverName, serverUrl)
        self.ch.addServer(serverName)

    def removeServer(self, serverName):
        self.servers.pop(serverName)
        self.ch.removeServer(serverName)

    def getServer(self, key):
        serverName = self.ch.resolveServer(key)
        return self.servers[serverName]
