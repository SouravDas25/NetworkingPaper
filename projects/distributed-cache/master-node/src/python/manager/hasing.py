class ConsistentHashing:

    def __init__(self, size):
        self.servePoints = []
        self.servers = {}
        self.size = size

    def addServer(self, serverId):
        serverIndex = hash(serverId) % self.size
        self.servePoints.append((serverIndex, serverId))
        self.servers[serverId] = serverIndex
        self.servePoints.sort()

    def removeServer(self, serverId):
        serverIndex = self.servers[serverId]
        self.servePoints.remove((serverIndex, serverId))
        self.servePoints.sort()

    def resolveServer(self, key):
        keyIndex = hash(key) % self.size
        for serverIndex, serverId in self.servePoints:
            if keyIndex <= serverIndex:
                return serverId
        return self.servePoints[0][1]


if __name__ == "__main__":
    ch = ConsistentHashing(1000)
    ch.addServer("dataServer0")
    ch.addServer("dataServer1")
    # ch.removeServer("dataServer1")
    print(ch.resolveServer("abcds"))
    print(ch.resolveServer("gyh"))
    print(ch.servePoints)
