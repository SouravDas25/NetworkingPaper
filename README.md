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
- Sliding Window
    - if continuous sub-array is asked,
    - sliding window does not work with negative no
    - [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
    - Longest Substring Without Repeating Character
    - https://leetcode.com/problems/continuous-subarray-sum
    -
- O(n) important Algorithms
    - [Maximum Absolute Difference](python/main/arrays/MaximumAbsoluteDifference.py)
    - [Majority Element](https://leetcode.com/problems/majority-element/)
    - [next-permutation](https://leetcode.com/problems/next-permutation/)
    - [Permutation Sequence](python/main/math/PermutationSequence.py)
- Cyclic Sort
    - [first-missing-positive](https://leetcode.com/problems/first-missing-positive/)
- String Sort
    - [largest-number](https://leetcode.com/problems/largest-number/)

- Two Pointer
    - two pointer with sorted Array
    - two pointer with sliding window
    - remove duplicate from sorted Array
    - Two Pointer to compare two list of intervals
        - [interval-list-intersections](https://leetcode.com/problems/interval-list-intersections/)

## Binary Search

- Matrix Search
- Median of 2 sorted Array
    - [Median Of Two Sorted Arrays](python/main/binary-search/MedianOfTwoSortedArrays.py)
- Search in Rotated Array
- Median of N Sorted Array
-

### LinkedList

- Traversal
    - Reverse linked List
        - [reverse-linked-list-ii](https://leetcode.com/problems/reverse-linked-list-ii/)
    - Middle Of linked List
        - [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
    - Traversal in Groups
        - [reverse-nodes-in-k-group](https://leetcode.com/problems/reverse-nodes-in-k-group/)
- Partition Linked List on some Condition
    - sort binary linked list
    - bucket sort
- Merge two Linked List
    - Merge to sorted Linked List
- Cycle
    - Detect Cycle
    - Find Cycle Point

### Stack

- Balance Parenthesis
    - [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
    - [valid-parenthesis-string](https://leetcode.com/problems/valid-parenthesis-string/)
- Tracking Previous Result
    - [largest-rectangle-in-histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
    - [maximal-rectangle](https://leetcode.com/problems/maximal-rectangle/)
    - [daily-temperatures](https://leetcode.com/problems/daily-temperatures/)
- Advance Stack
    - Min Stack
    - Max Stack
- Infix 2 PostFix
- Expression Evaluation
    - [Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

### Queue & Strings

### Heap, Maps & Hashing

- K or Kth Largest / Smallest Element
    - k largest element
- min and max Heap Combination
    - Median of Input Stream
- Caches
    - LRU Cache
    - LFU Cache
    - LRU with Time to Live
- Merge K Sorted List
- Hashing
    - Points on a Straight Line
    - [fraction-to-recurring-decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

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

- Generate All Binary Trees
    - [Unique Binary Search Trees](python/main/tree/UniqueBinarySearchTrees.py)
    - [all-possible-full-binary-trees](https://leetcode.com/problems/all-possible-full-binary-trees/)

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

- In/Out Degree of Graph
    - count the incoming connections and outgoing connections in each node
        - [minimum-number-of-vertices-to-reach-all-nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/)

- Strongly Connected Components
    - Kosaraju's Algorithm
        - reverse DFS
        - [Strongly Connected Graphs](python/main/graphs/StronglyConnectedGraphs.py)

- Single Source Shortest Path
    - Bellman Fords Algorithm
        - [Bellman Ford Algorithm](python/main/graphs/BellmanFordAlgorithm.py)
    - Dijsktra Algorithm
        - [Dijkstra Algorithm](python/main/graphs/DijkstraAlgorithm.py)

- All Pair Shortest Path
    - Floyd-Warshall Algorithm
        - [Floyd Warshall Algorithm](python/main/graphs/FloydWarshallAlgorithm.py)

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

- # [Greedy Algorithms](https://www.geeksforgeeks.org/greedy-algorithms/)

### Dynamic Programming

- Find out the item used from the DP problem
    - [Coin Change](python/main/dp/CoinChange.py)
- Constant Space DP
    - [climbing-stairs](https://leetcode.com/problems/climbing-stairs/)
    - Selecting Alternating items
        - [house-robber](https://leetcode.com/problems/house-robber/)
        - [delete-and-earn](https://leetcode.com/problems/delete-and-earn/)
- 1D Dp
    - Simple Array DP
        - [longest-increasing-subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
        - [Unique Binary Search Trees](python/main/tree/UniqueBinarySearchTrees.py)
- 2D Dp

- Knapsack 0/1
    - Subset Sum Problem
        - [Partition Equal Subset Sum](python/main/dp/PartitionEqualSubsetSum.py)
    - Equal Sum Partition problem
    - Target Sum
- Knapsack Unbounded
    - Coin Change Problem
        - [Coin Change](python/main/dp/CoinChange.py)
    - Rod Cutting Problem
    - Maximum Product Cutting
- Longest Common Subsequence
    - [Longest Common Subsequence](python/main/dp/LongestCommonSubsequence.py)
    - [Longest Palindromic Subsequence](python/main/dp/LongestPalindromicSubsequence.py)
- Egg Dropping Problem
    - [Super Egg Drop](python/main/dp/SuperEggDrop.py)
- Matrix Chain Multiplication
- [Word Break](https://leetcode.com/problems/word-break/)
- [Palindromic Partitioning](https://leetcode.com/problems/palindrome-partitioning-ii/)
- DP with Grid — Unique Paths
- DP with Strings
- DP with bit-masking

ALL DP Questions : [DP PROBLEMS](dp.md)

### Advance Data Structures

- Fibonacci Heap
- Splay Trees
- Dynamic graph data structures

### Augmenting Data Structures

- Order statistics
    - Find i'th smallest element
    - Randomized Quick Sort Partitions with Divide & Conquer - O(n)
    - Augmented Red Black Trees - O(log n)
- Interval Trees
    - find overlapping intervals in O(log n) time.
    - augmented red black trees
- Segment Trees
    - get SUM, MIN, MAX in O(log n) time
    - 
