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
      - [Cousins In Binary Tree](python/main/tree/CousinsBinaryTree.py)
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

- Memoization
  - [best-time-to-buy-and-sell-stock-iv](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
  - [best-time-to-buy-and-sell-stock-ii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

### Greedy

- Greedy with single Array Traversal
  - [valid-parenthesis-string](https://leetcode.com/problems/valid-parenthesis-string/)
- Reverse traversal of Array, with cache
  - [jump-game II](https://leetcode.com/problems/jump-game-ii/)
- use min heap to take greedy decision
  - [merge-triplets-to-form-target-triplet](https://leetcode.com/problems/merge-triplets-to-form-target-triplet/)

- [Greedy Algorithms](https://www.geeksforgeeks.org/greedy-algorithms/)

### Dynamic Programming
- Constant Space DP
  - [climbing-stairs](https://leetcode.com/problems/climbing-stairs/)
- 1D Dp
  - Simple Array DP
    - [longest-increasing-subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
    - [Unique Binary Search Trees](python/main/tree/UniqueBinarySearchTrees.py)
- 2D Dp
