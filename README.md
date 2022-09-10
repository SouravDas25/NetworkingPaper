Data Structure & Algorithms
==============================

### Arrays

- Suffix & Prefix Array, sum or product
    - Suffix Arrays with cache
        - [Sub-Array Sum With K](https://leetcode.com/problems/subarray-sum-equals-k/)
- sum or product except self
    - total = sum(array), for each item, subtract that from total
    - total = product(array), for each item, divide that from total
        - track division by zero
- sliding Window
    - if continous sub-array is asked,
    - sliding window does not work with negative no
    - [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
- pre

### LinkedList

### Stack

### Queue

### Trees
- Property of tree
  - [Maximum Edge Removal](python/main/tree/MaximumEdgeRemoval.py)
- DFS
    - InOrder
        - keeping answer in global variable
        - traverse 2 trees together
          - [merge-two-binary-trees](https://leetcode.com/problems/merge-two-binary-trees/)
    - PreOrder
    - PostOrder
    - Vertical Order Traversal
        - [Vertical Sum Of Binary Tree](python/main/tree/VerticalSumOfBinaryTree.py)
    - Level Order Traversal
      - (Cousins In Binary Tree)[python/main/tree/CousinsBinaryTree.py]
    - Diagonal Order Traversal
      - [diagonal-traversal](https://www.interviewbit.com/problems/diagonal-traversal/)
- BFS
    - Level Order Traversal
        - Left and Right Side View of the tree
            - [Cover and Uncover Nodes](python/main/tree/CoveredUncoveredNodes.py)
        - Level Zig Zag Traversal
    -
- DFS + BFS
    - Parent + Children Traversal
        - [All Nodes Distance K in Binary Tree](python/main/tree/AllNodesDistanceKBinaryTree.py)

- DP Solution 
  - Callan Number
    - [Unique Binary Search Trees](python/main/tree/UniqueBinarySearchTrees.py)

### Graph

- Adj List
- Matrix
- Cycle Detection
    - Directed
        - use DFS with global and local visited set,
        - [Cycle In Directed Graph](python/main/graphs/CycleDirectedGraph.py)
    - Undirected
        - use Union Find // union find only works with undirected
        - [Cycle In Undirected Graph](python/main/graphs/CycleUndirectedGraph.py)
- BFS
    - Bi-directional BFS
    - Normal BFS
        - use queue
    - Heap BFS
        - pick min weight of graph
        - [Commutable Island](python/main/graphs/CommutableIslands.py)
- DFS
    - iterative DFS with stack
        - [Cycle In Directed Graph](python/main/graphs/CycleDirectedGraph.py)
    - use recursion for normal, use global and local visited set
        - [Course Schedule](python/main/graphs/CourseSchedule.py)
- Union Find
    - find disconnected graphs
        - [Number Of Provinces](python/main/graphs/NumberofProvinces.py)
    - find parent of each nodes with ranking
        - [Cycle In Undirected Graph](python/main/graphs/CycleUndirectedGraph.py)
- Minimal Spanning Tree
    - do bfs for minimum using heap, instead of queue
        - [Commutable Island](python/main/graphs/CommutableIslands.py)
- Topological Sort
    - use dfs and the reverse the traversed list
        - [Course Schedule](python/main/graphs/CourseSchedule.py)
    - All topological sorts of a Directed Acyclic Graph

### Recursion/backtracking

### Greedy

- [Greedy Algorithms](https://www.geeksforgeeks.org/greedy-algorithms/)

### Dynamic Programming
