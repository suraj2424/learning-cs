package Topics.Graphs;
import java.util.*;
class Helper_Cycle_Detection_BFS {
    // edges 0 : V-1
    boolean helperCycleBFS(List<List<Integer>> adj, boolean[] visited, int src, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int nbr : adj.get(node)) {
                if(!visited[nbr]) {
                    q.offer(nbr);
                    visited[nbr] = true;
                    parent[nbr] = node;
                }
                else if(parent[node] != nbr) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean isCycle(int[][] egdes, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : egdes) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean ans = helperCycleBFS(adj, visited, i, parent);
                if(ans == true) return true;
            }
        }
        return false;
    }
}

public class Cycle_Detection_BFS {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 1}}; // true
        Helper_Cycle_Detection_BFS hcdb = new Helper_Cycle_Detection_BFS();
        System.out.println(hcdb.isCycle(edges, V));
    }
}
