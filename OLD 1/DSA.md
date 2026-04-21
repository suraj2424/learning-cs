# TREES

## TRAVERSALS
**1. Inorder Traversal**
- Left - Root - Right

**2. PreOrder Traversal**


# GRAPHS

**Example**: Social Networks, Maps, Dependency Resolution, Optimal Routing

**Definition**: A graph is all about relationships

*Real Life Examples:*
1.	Cities connected by roads -> Transportation Graph
2.	People connected by friendships -> Social Graph
3.	Webpages linked by Hyperlinks -> Web Graph

Graph 
: A set of nodes (*vertices*) + edges (*connections*) between them.

Here, 
Edges can be:
1. Directed
2. Undirected
3. Have weights (Distance/Cost)
4. Or not (Just represent connectivity)

So graphs exist because regular data structures (arrays, lists, trees) can’t easily represent arbitrary relationships between entities.

### *CORE PATTERNS*
1.	**Traversal Patterns**
- Goal: explore or visit nodes systematically
- Common tools: BFS (breadth-first search), DFS (depth-first search)
2.	**Shortest Path Patterns**
- Goal: find minimal cost/distance from source to destination
- Common tools: Dijkstra’s, Bellman-Ford, Floyd–Warshall
3.	**Connectivity & Components**
•	Goal: find groups, cycles, or bridges (disconnected parts)
•	Common tools: Union-Find (Disjoint Set Union—DSU), DFS
4.	**Topological Ordering** (for directed acyclic graphs)
•	Goal: figure out "what must come before what"
•	Common tools: DFS-based topo sort, Kahn’s algorithm
5.	Minimum Spanning Trees
•	Goal: connect all nodes with minimal total edge weight
•	Common tools: Kruskal’s and Prim’s algorithms

### ⚠️ STEP-BY-STEP Strategy
- Whenever you face a graph problem, train yourself to ask:
1.	**Directed or undirected?**
- The direction changes how you interpret connectivity.
2.	**Weighted or unweighted?**
- Determines whether you can use BFS or need something like Dijkstra’s.
3.	**Goal:** *Traverse, check connectivity, find shortest path, or optimize something?*
This clue usually points to which algorithm pattern fits.
4.	**Graph Representation** — How to store it efficiently:
- Adjacency List: `{ node: [neighbors] }` → most common, memory efficient.
- Adjacency Matrix: 2D matrix → simple but heavy (O(V²) space).
5.	**Complexity Tradeoffs:**
- Traversals (BFS/DFS): **O(V + E)**
- Dijkstra’s: O(E log V) with a priority queue
- Union-Find operations: almost O(1) amortized


### Graph Traversals

#### 1. BFS (Breadth First Search)

- You’re the “systematic sweeper.” You visit your immediate neighbors first, then their neighbors, then their neighbors, like expanding in waves.
- Essentially: go level by level outward from the starting point.

**Core Patterns**

- Finding the shortest path in unweighted graphs
- Level-order traversal of trees
- “Steps / distance” kind of problems (like “minimum moves to reach target”)

**Algorithm**
1. Use a queue (because it processes things “first in, first out”).
2. Start at a node → enqueue it and mark it as visited.
3. While the queue isn’t empty:
	- Dequeue the front node
	- For each neighbor:
		- If not visited, enqueue it and mark as visited

**Example Walkthrough**

	A - B
	|   |
	C - D

- Lets start from **A**.
- Neighbors of **A** --> Node **B**,**C**.
- Then their neighbors --> Node **D**.
- Looks like **A --> B --> C --> D**

#### 2. DFS (Depth First Search)

- You’re the “let me finish this route before I check others” type.
- You pick one road, go as far as you can until you hit a dead end, then backtrack and try another.
Essentially: go deep, then backtrack.

**Core Patterns**

- Detecting cycles
- Topological sorting
- Checking connectivity (“can we reach X?”)
- Maze-solving problems

**Algorithm** (recursive idea):
1. Start at a node.
2. Mark it as visited.
3. For each neighbor:
4. If not visited, call DFS on that neighbor.
5. It’s like diving into one tunnel until you can’t go further, then backtracking.

**Example Walkthrough**

	A - B
	|   |
	C - D

- Lets start from **A**.
- Visit neighbor **B** --> then from **B** to visit node **D** --> then from **D** visit node **C**.
- Looks like **A --> B --> D --> C**

#### ⚖️ Time & Space
Both visit each vertex and each edge once → O(V + E)

*Differences*:
- DFS uses recursion (stack) — **space ∼ depth of graph**
- BFS uses queue — **space ∼ number of nodes at current level**


## ⚔️ **PROBLEM**
- *Difficulty:* Easy
- *Title:* Implement BFS and DFS on an unweighted graph.
![alt text](image.png)

- **Add edges in the DS**
```java
class AdjListGraph {
	private ArrayList<ArrayList<Integer>> adjList;

	public AdjListGraph(int vertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

	public static void main(String[] args) {
		AdjListGraph graph = new AdjListGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		System.out.println("BFS Traversal starting from node 0:");
		graph.bfs(0);

		System.out.println("\nDFS Traversal starting from node 0:");
		graph.dfs(0);
	}
}
```

- **BFS Implementation**
```java
class BFS {
	public void bfs(ArrayList<ArrayList<Integer>> adj, int start) {
		boolean[] visited = new boolean[adj.size()];
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int neighbor : adj.get(node)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
}
```
- **DFS Implementation**
```java
class DFS {
	public void dfsUtil(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
		visited[node] = true;
		System.out.print(node + " ");

		for (int neighbor : adj.get(node)) {
			if (!visited[neighbor]) {
				dfsUtil(adj, neighbor, visited);
			}
		}
	}

	public void dfs(ArrayList<ArrayList<Integer>> adj, int start) {
		boolean[] visited = new boolean[adj.size()];
		dfsUtil(adj, start, visited);
	}
}
```

- **Output**
```
BFS Traversal starting from node 0:
0 1 2 3 4

DFS Traversal starting from node 0:
0 1 3 2 4
```



## 1. Weighted Graphs and Dijkstra's Algorithm

**Concept intuition**: some edges are “longer” or “more expensive.”
We’ll learn how to find the minimum total cost from a source node to every other node.
It answers questions like “What’s the shortest route between cities when roads have different distances?”

- *Key ideas to focus on*:
	-	Priority‑based exploration (using a min‑heap / priority queue)
	-	Comparing Dijkstra vs BFS—how BFS is just Dijkstra with equal weights.
	-	How to track both distance and parent nodes to reconstruct paths.

### 🧭 Core Pattern
Dijkstra’s pattern is grounded in a simple rule:
> "Always expand the cheapest currently known path next."

This means maintaining a priority of which vertex to explore—using a min‑heap (priority queue) so that the next node you process is always the one with the smallest tentative distance.

**Recognizing Dijkstra problems:**

Whenever a problem says “find minimum time/cost/distance” and all weights are non‑negative, that’s our cue.

### ⚠️ Common Mistakes

1. Using Dijkstra when weights can be negative — that breaks it.
2. Forgetting to maintain a proper min‑heap, causing wrong order of expansion.
3. Not checking whether a node’s new distance is truly better before pushing again — leading to inefficient duplicates.
4. Using BFS logic (queue) instead of priority logic — BFS assumes all weights = 1.


### 🔨 SPECIAL CASE
1. IF Problem asks for `Probability` use **MAX-HEAP** instead of MIN-HEAP.

*CONSTRUCTOR*
```java
class Pair {
	int neighbor;
	double probability;
	public Pair(int n, double p) {
		this.neighbor = n;
		this.probability = p;
	}
	@Override
	public int compareTo(Pair o) {
		return Double.compare(o.probability, this.probability);
	}
}
```




## 2. Directed Graphs and Topological Sorting

**Concept intuition**: some relationships have a direction (like prerequisites).

- This involves following types of problems:
	-	Task scheduling (“do X before Y” problems)
	-	Build order resolution (“which course must be taken first?”)
	-	Dependency resolution (e.g., build systems)

**Patterns to learn:**
- Adapting traversal for one‑way edges
- Cycle detection in directed graphs
- Topological sort (Kahn’s algorithm and DFS version)

## 🧩 3. Union–Find (Disjoint Set Union)
- This structure helps when you need to group or merge connected items efficiently.

*Common applications:*
- “Are two nodes in the same component?”
- Kruskal’s algorithm for Minimum Spanning Tree
- Dynamic connectivity problems

## 🕸️ 4. Classic Optimization Problems
- Minimum Spanning Tree — Prim’s and Kruskal’s (weighted, undirected)
- Strongly Connected Components — Kosaraju / Tarjan (directed)
- Bridges & Articulation Points — critical connections in a network

| Stage | Topic | Example Problem |
| ----------- | ----------- | ----------- |
| 1	| Dijkstra’s algorithm |	Shortest path in a weighted graph (network routing) |
| 2 |	Topological sort |	Course schedule / task ordering |
| 3 |	Union–Find	| Connect islands / Kruskal’s MST |
| 4	| MST |	Connect all cities with minimal cost |
| 5 |	SCC or Bridges	| Identify weak points in a road network |

## ALGORITHMS

### 1: Dijkstra Algorithm

#### *⚙️ Step‑by‑Step Strategy*
1. **Set up data:**

- Graph as adjacency list: `{node: [(neighbor, weight), …]}`
- Distance array: keeps shortest distance from source to every vertex (start as infinity).
- Min‑heap priority queue: keeps track of the current best node to process.

2. **Initialize:**
- Distance[source] = 0
- Push `(0, source)` into min‑heap

3. **Process nodes:**	
	
	While heap not empty:

   - Pop the node with the smallest distance (the "most promising" one so far).
   - For each of its neighbors:
     - Compute `new_distance = current_distance + edge_weight`
     - If `new_distance` is smaller than the recorded distance → update and push neighbor to heap.
Repeat until all reachable nodes processed.

#### 🧰 Time & Space
With a binary heap (priority queue):

- Time: **O((V + E) log V)**
- Space: **O(V + E)**

### 2: Bellman Ford

**Why it exists**
Dijkstra fails if any `edge` has a negative weight (it assumes adding edges always increases total cost).
Real systems—like currency exchange rates, gain‑loss networks, or algorithms detecting arbitrage—may have negative weights.

**Bellman–Ford fixes that tradeoff:**
it’s slower but guaranteed correct even for negative weights, and it can also detect negative cycles.

#### Core idea
Instead of exploring cheapest node first, it simply does:
> “Relax every edge repeatedly.”

- Initialize dist[source] = 0, others = ∞.
- Repeat V−1 times: for each edge (u, v, w), do 
	- if `dist[u] + w < dist[v] → update dist[v]`.
- After those passes, a further improvement means a negative cycle exists.

That gives correctness through brute‑force relaxation rather than smart ordering.

```java
import java.util.*;

public class BellmanFord {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;  this.v = v;  this.w = w;
        }
    }

    // n = no of edges
    public static int[] bellmanFord(int n, List<Edge> edges, int src) {
        final int INF = (int)1e9;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Step 1 – Relax all edges (V – 1) times
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }
            if (!updated) break; // optimization
        }

        // Step 2 – Check for negative‑weight cycle
        for (Edge e : edges) {
            if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                throw new RuntimeException("Graph contains a negative‑weight cycle");
            }
        }

        return dist;
    }

    // Demo
    public static void main(String[] args) {
        int n = 5, src = 0;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 3, 7));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 1, -2));
        edges.add(new Edge(3, 2, -3));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 2, 7));

        int[] dist = bellmanFord(n, edges, src);
        for (int i = 0; i < n; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }
}
```
`OUTPUT:`
Distance from 0 to 0 = 0
Distance from 0 to 1 = 2
Distance from 0 to 2 = 4
Distance from 0 to 3 = 7
Distance from 0 to 4 = -2

#### Complexity: `O(V × E)`
---
### 3: 0-1BFS

#### Why it exists
Sometimes edges have only weights 0 or 1 (e.g., switching states, binary transitions).
Running normal Dijkstra is overkill; you can use a deque (double‑ended queue) and achieve **O(V + E)** time.

#### Essence
When you traverse:
-	If edge weight = 0 → push front.
- If edge weight = 1 → push back.

That keeps shortest distances without a heap.
It blends BFS efficiency with weighted logic.

### 4: Floyd–Warshall Algorithm
#### Why it exists
You’ve learned `single‑source algorithms` (BFS, Dijkstra, Bellman–Ford).
Floyd–Warshall generalizes to all‑pairs shortest paths.
Sometimes we need distance from every vertex to every other vertex (e.g., routing tables).

#### Essence
Dynamic‑programming approach:
> "For each intermediate node k, try to improve distance[i][j] using node k as a bridge."

```ALGORITHM
for k in range(V):
    for i in range(V):
        for j in range(V):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
```


```java
import java.util.*;

public class FloydWarshall {
    static final int INF = (int)1e9;

    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Deep copy of input matrix
        for (int i = 0; i < n; i++)
            dist[i] = Arrays.copyOf(graph[i], n);

        // DP triple loop
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF
                        && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    // Demo
    public static void main(String[] args) {
        int INF = (int)1e9;
        int[][] graph = {
            {0,   5,  INF, 10},
            {INF, 0,   3,  INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        int[][] dist = floydWarshall(graph);

        System.out.println("All‑pairs shortest distances:");
        for (int[] row : dist) {
            for (int d : row)
                System.out.print((d >= INF ? "INF" : d) + "\t");
            System.out.println();
        }
    }
}
```
`OUTPUT:`
0       5       8       9
INF     0       3       4
INF     INF     0       1
INF     INF     INF     0

#### Complexity: O(V³)
---

| Stage | Concept | Core idea | Key Difference | Practice Example |
|---|---|---|---|---|
| 1 | Bellman Ford | Repeated Relaxation | Handles negative weights | Detect negative cycle in graph |
| 2 | 0-1BFS | Deque-based traversal for 0/1 weights | Faster than dijkstra | Minimum edge flips in binary grid |
| 3 | Floyd Warshall | DP for all pairs | Gets every shortest distance | Find the city with shortest reachable distances |


