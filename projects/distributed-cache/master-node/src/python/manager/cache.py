from cluster import ServerCluster
from bloom_filter2 import BloomFilter


class CacheConfig:

    def __init__(self):
        self.config = ""
        self.cacheSize = 1000
        self.scaleFactor = 2


class DistributedCache:

    def __init__(self):
        self.config = CacheConfig()
        self.serverCluster = ServerCluster(self.config.cacheSize)
        self.bloom = BloomFilter(self.config.cacheSize, error_rate=0.01)

    def put(self, key, value):
        server = self.serverCluster.getServer(key)
        server.put(key, value)
        self.bloom.add(key)

    def get(self, key):
        server = self.serverCluster.getServer(key)
        return server.get(key)

    def has(self, key):
        return key in self.bloom


if __name__ == "__main__":
    dc = DistributedCache()
    dc.put("apple", "pie")
    print(dc.get("apple"))
    print(dc.has("apple"))
