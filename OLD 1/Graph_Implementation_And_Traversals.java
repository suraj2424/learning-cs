import java.util.*;
// import java.lang.*;
// import java.io.*;

class Graph_Implementation_And_Traversals {
    void bfs(ArrayList<ArrayList<Integer>> adj,int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        
        // add start
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node +" ");
            for(int neighbor : adj.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj,int start) {
        boolean[] visited = new boolean[adj.size()];
        dfsUtil(adj, start, visited);
    }
    
    static void dfsUtil(ArrayList<ArrayList<Integer>> adj,int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start +" ");
        for(int neighbor : adj.get(start)){
            if(!visited[neighbor]) {
                dfsUtil(adj, neighbor, visited);
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    int v;
    int d;
    public Pair(int vertex, int distance) {
        this.v = vertex;
        this.d = distance;
    }
    
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.d, other.d);
    }
}

class Dijkstra {
    int[] dijkstra(int V, List<List<Pair>> adj, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[source] = 0;
        pq.add(new Pair(source, 0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.v;
            int currentDistance = current.d;
            
            if (currentDistance > d[u]) {
                continue;
            }
            
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.v;
                int weight = neighbor.d;
                
                if (currentDistance + weight < d[v]) {
                    d[v] = currentDistance + weight;
                    pq.offer(new Pair(v, d[v]));
                }
            }
        }
        
        return d;
    }
}

class Run {
    public static void main (String[] args) {
        Graph_Implementation_And_Traversals giat = new Graph_Implementation_And_Traversals();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<5; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(4);
        System.out.println("BFS Output: ");
        giat.bfs(adjList, 0);
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("DFS Output: ");
        giat.dfs(adjList, 0);



        Dijkstra dj = new Dijkstra();
        int V = 3;
        List<List<Pair>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges
        adj.get(0).add(new Pair(1, 1));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 2));
        
        int[] ans = dj.dijkstra(V, adj, 0);
        System.out.println(Arrays.toString(ans)); // Should output: [0, 1, 3]



    }
}