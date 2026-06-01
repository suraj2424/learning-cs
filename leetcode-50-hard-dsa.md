# 🚀 50 Hard LeetCode Problems — Complete DSA Pattern Mastery

A hand-curated list of **50 problems** (mostly Hard, a few "spicy" Mediums) chosen so that by the time you finish, you'll have touched **every core DSA pattern** at least once — usually twice.

> **How to use this list**
> 1. Go pattern-by-pattern, top to bottom (it's roughly ordered easy → brutal within each section).
> 2. Give each problem an honest **45 min** attempt before looking at hints.
> 3. After solving, write a 2-line note: *what was the key insight?* That note is what actually compounds.
> 4. Re-solve any problem you struggled with after ~1 week (spaced repetition).

**Progress:** `0 / 50` ✅

---

## 📊 Pattern Coverage Map

| # | Pattern | Problems | Why it matters |
|---|---------|----------|----------------|
| 1 | Arrays & Hashing | 2 | In-place tricks, index-as-hash |
| 2 | Two Pointers | 2 | Converging/diverging pointers |
| 3 | Sliding Window | 3 | Variable-size windows + hashing |
| 4 | Monotonic Stack | 3 | Next-greater / area problems |
| 5 | Binary Search | 3 | Search on answer space |
| 6 | Linked List | 2 | Pointer surgery |
| 7 | Trees | 4 | DFS return-value design |
| 8 | Tries | 2 | Prefix structures |
| 9 | Heap / Priority Queue | 3 | Top-K, two-heap, scheduling |
| 10 | Backtracking | 3 | Constraint search + pruning |
| 11 | Graphs (BFS/DFS) | 3 | Traversal + state modeling |
| 12 | Advanced Graphs | 4 | Dijkstra, 0-1 BFS, Euler, bridges |
| 13 | Topological Sort | 1 | Dependency ordering |
| 14 | Union-Find (DSU) | 2 | Dynamic connectivity |
| 15 | 1-D DP | 4 | Subsequence / decision DP |
| 16 | 2-D DP | 5 | Grid, string, interval DP |
| 17 | Greedy | 3 | Exchange argument |
| 18 | Intervals | 2 | Sweep line / merging |
| 19 | Bit Manipulation | 1 | XOR tricks + bit-trie |
| 20 | Math & Geometry | 1 | Slope / precision |
| 21 | Segment Tree / BIT | 2 | Range queries + inversions |

**Total: 50 problems across 21 patterns** 🎯

---

## 1️⃣ Arrays & Hashing

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 41 | [First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | Hard | Index-as-hash, cyclic placement |
| ☐ | 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | HashSet O(n) sequence walk |

## 2️⃣ Two Pointers

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Hard | Two pointers + max-from-both-sides |
| ☐ | 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Hard | Shrinking window + need/have map |

## 3️⃣ Sliding Window

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Monotonic deque |
| ☐ | 30 | [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | Hard | Fixed-window word buckets |
| ☐ | 992 | [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) | Hard | atMost(K) − atMost(K-1) |

## 4️⃣ Monotonic Stack

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 84 | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Hard | Increasing stack, width on pop |
| ☐ | 85 | [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | Hard | Histogram per row (#84 reuse) |
| ☐ | 224 | [Basic Calculator](https://leetcode.com/problems/basic-calculator/) | Hard | Stack for sign/parentheses |

## 5️⃣ Binary Search

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard | Binary search on partition |
| ☐ | 410 | [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/) | Hard | Binary search on the answer |
| ☐ | 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Identify sorted half |

## 6️⃣ Linked List

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Min-heap / divide & conquer |
| ☐ | 25 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | In-place segment reversal |

## 7️⃣ Trees

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 124 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | DFS returns gain, updates global |
| ☐ | 297 | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Hard | Preorder + null markers |
| ☐ | 987 | [Vertical Order Traversal of a Binary Tree](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) | Hard | BFS + (col,row,val) sort |
| ☐ | 968 | [Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/) | Hard | Greedy DFS state machine |

## 8️⃣ Tries

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 212 | [Word Search II](https://leetcode.com/problems/word-search-ii/) | Hard | Trie + DFS pruning on grid |
| ☐ | 472 | [Concatenated Words](https://leetcode.com/problems/concatenated-words/) | Hard | Trie / DP word-break |

## 9️⃣ Heap / Priority Queue

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 295 | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | Hard | Two heaps (max+min) |
| ☐ | 218 | [The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | Hard | Sweep line + max-heap |
| ☐ | 502 | [IPO](https://leetcode.com/problems/ipo/) | Hard | Greedy + two heaps |

## 🔟 Backtracking

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 51 | [N-Queens](https://leetcode.com/problems/n-queens/) | Hard | Column/diagonal sets pruning |
| ☐ | 37 | [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | Hard | Constraint propagation |
| ☐ | 140 | [Word Break II](https://leetcode.com/problems/word-break-ii/) | Hard | Backtrack + memo on suffix |

## 1️⃣1️⃣ Graphs (BFS / DFS)

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 127 | [Word Ladder](https://leetcode.com/problems/word-ladder/) | Hard | BFS shortest path / bi-BFS |
| ☐ | 1293 | [Shortest Path in a Grid with Obstacles Elimination](https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/) | Hard | BFS with extra state dim |
| ☐ | 685 | [Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | Hard | DSU + cycle/indegree cases |

## 1️⃣2️⃣ Advanced Graphs

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 778 | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | Hard | Dijkstra / binary search + BFS |
| ☐ | 1368 | [Minimum Cost to Make at Least One Valid Path in a Grid](https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/) | Hard | 0-1 BFS (deque) |
| ☐ | 332 | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) | Hard | Hierholzer's (Eulerian path) |
| ☐ | 1192 | [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | Hard | Tarjan's bridges (low-link) |

## 1️⃣3️⃣ Topological Sort

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 269 | [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | Hard | Build graph + Kahn's BFS |

## 1️⃣4️⃣ Union-Find (DSU)

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 305 | [Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/) | Hard | Incremental union + count |
| ☐ | 803 | [Bricks Falling When Hit](https://leetcode.com/problems/bricks-falling-when-hit/) | Hard | Reverse-time union to roof |

## 1️⃣5️⃣ 1-D Dynamic Programming

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 32 | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | Hard | DP / stack of indices |
| ☐ | 354 | [Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/) | Hard | Sort + LIS (patience) |
| ☐ | 123 | [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | State-machine DP |
| ☐ | 1235 | [Maximum Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | Hard | DP + binary search |

## 1️⃣6️⃣ 2-D Dynamic Programming

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 72 | [Edit Distance](https://leetcode.com/problems/edit-distance/) | Hard | Classic string DP grid |
| ☐ | 10 | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | Hard | Pattern DP with `*` / `.` |
| ☐ | 115 | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | Hard | Count-paths DP |
| ☐ | 312 | [Burst Balloons](https://leetcode.com/problems/burst-balloons/) | Hard | Interval DP (last to burst) |
| ☐ | 741 | [Cherry Pickup](https://leetcode.com/problems/cherry-pickup/) | Hard | Two-path simultaneous DP |

## 1️⃣7️⃣ Greedy

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 135 | [Candy](https://leetcode.com/problems/candy/) | Hard | Two-pass left/right |
| ☐ | 45 | [Jump Game II](https://leetcode.com/problems/jump-game-ii/) | Medium | BFS-style greedy reach |
| ☐ | 330 | [Patching Array](https://leetcode.com/problems/patching-array/) | Hard | Greedy reachability bound |

## 1️⃣8️⃣ Intervals

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 56 | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | Medium | Sort + sweep |
| ☐ | 759 | [Employee Free Time](https://leetcode.com/problems/employee-free-time/) | Hard | Merge + find gaps |

## 1️⃣9️⃣ Bit Manipulation

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 421 | [Maximum XOR of Two Numbers in an Array](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) | Medium | Bitwise trie, greedy bits |

## 2️⃣0️⃣ Math & Geometry

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 149 | [Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/) | Hard | Slope hashing (gcd) |

## 2️⃣1️⃣ Segment Tree / Binary Indexed Tree

| ✅ | # | Problem | Difficulty | Key Technique |
|----|-----|---------|------------|---------------|
| ☐ | 315 | [Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | Hard | BIT / merge-sort inversions |
| ☐ | 308 | [Range Sum Query 2D - Mutable](https://leetcode.com/problems/range-sum-query-2d-mutable/) | Hard | 2D BIT (Fenwick) |

---

## 🗺️ Suggested 8-Week Roadmap

| Week | Focus Patterns | Problems |
|------|----------------|----------|
| 1 | Arrays, Two Pointers, Sliding Window | #41, 128, 42, 76, 239, 30, 992 |
| 2 | Monotonic Stack, Binary Search | #84, 85, 224, 4, 410, 33 |
| 3 | Linked List, Trees | #23, 25, 124, 297, 987, 968 |
| 4 | Tries, Heaps, Backtracking | #212, 472, 295, 218, 502, 51, 37, 140 |
| 5 | Graphs (BFS/DFS + Advanced) | #127, 1293, 685, 778, 1368, 332, 1192 |
| 6 | Topo Sort, Union-Find, 1-D DP | #269, 305, 803, 32, 354, 123, 1235 |
| 7 | 2-D DP | #72, 10, 115, 312, 741 |
| 8 | Greedy, Intervals, Bit, Math, Seg-Tree | #135, 45, 330, 56, 759, 421, 149, 315, 308 |

---

## 🧠 Pro Tips for Cracking Hard Problems

1. **Recognize the pattern first.** Most "hard" problems are a known pattern + one twist. Ask: *which of my 21 patterns smells right?*
2. **Brute force out loud,** then optimize. State the O(n²)/exponential solution before reaching for the clever one.
3. **For DP:** define the *state* and *transition* in plain English before writing code.
4. **For graphs:** decide BFS vs DFS vs Dijkstra vs DSU based on weights & query type.
5. **Don't memorize solutions — memorize insights.** "Burst Balloons = think about the *last* balloon" is worth more than the code.
6. **Time-box to 45 min.** If stuck, read *only the approach* (not code), close it, and re-derive.

---

*Happy grinding! Tick the boxes (`☐ → ✅`) as you go and you'll have covered the entire DSA landscape through hard problems. 💪*
