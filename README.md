# NetworkingPaper


Data Structure & Algorithms
==============================

### Arrays
### LinkedList
### Stack
### Queue
### Trees
  - DFS 
    - InOrder 
      - keeping answer in global variable
      - 
    - PreOrder
    - PostOrder
    - Vertical Order
    - 
  - BFS 
    - Level Order
    - Zig Zag
    - Left side view/ Right Side View
  - 
### Graph
  - Adj List
  - Matrix
  - Cycle Detection
    - Directed 
      - use dfs with global and local visited set,  
    - Undirected 
      - use Union Find // union find only works with undirected
  - BFS
    - Bi-directional BFS
    - Normal BFS
      - use queue 
    - Heap BFS 
      - pick min weight of graph
  - DFS
  - Union Find
    - find disconnected graphs
    - find parent of each nodes with ranking
  - Minimal Spanning Tree
    - do bfs for minimum using heap, instead of queue
  - Topological Sort
    - use dfs and the reverse the traversed list
### Recursion/backtracking
- Greedy
- Dynamic Programming


#### Union Find

Cycle Detection in Undirected Graph
```python
class Solution:

    def find(self, n, parent):
        while parent[n] != n:
            parent[n] = parent[parent[n]]
            n = parent[n]
        return parent[n]

    def solve(self, n, edges):
        parent = {}
        rank = {}
        for i in range(1, n + 1):
            parent[i] = i
            rank[i] = 1

        for e1, e2 in edges:
            p1 = self.find(e1, parent)
            p2 = self.find(e2, parent)
            if p1 != p2:
                if rank[p1] < rank[p2]:
                    parent[p2] = p1
                    rank[p1] += 1
                else:
                    parent[p1] = p2
                    rank[p2] += 1
            else:
                return 1
        return 0
```
