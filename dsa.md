# Aditya Verma Graphs Series

## Topics Covered

1. **What are graphs?**
2. **Types of graphs**
3. **Graph Implementations**
   - Adjacency List
   - Adjacency Matrix
4. **Graph Traversal**
   - BFS [Breadth First Search]
   - DFS [Depth First Search]
   - Time Complexity (TC)
5. **Problems**
   - Valid Path (Leetcode)
   - Steps By Knight (GFG)
   - Knight Probability in Chessboard (Leetcode)
   - Reorder Routes to Make All Paths Lead to the City Zero (Leetcode)
6. **Cycle Detection in Undirected Graph**
   - Using BFS
   - Using DFS
7. **Cycle Detection in Directed Graph**
   - DFS
8. **Topological Sort**
   - Only works on DAG (Directed Acyclic Graph)
   - BFS (Using Kahn's Algorithm)
   - DFS (Nodes storing changes slightly) 

---


# 8.Topological Sorting
- Sorting (arranging data) 
- DAG (Directed Acyclic Graph)

## How does this works
- visit the nodes which dont have prerequisite (indegree).
- 1 DAG can have multiple answers for `Topological Sort.`

