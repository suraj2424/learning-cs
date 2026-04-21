package Topics.Graphs;
import java.util.*;

class Helper_Cycle_Detection_Revision {
    /* Nodes 0-indexed 0 to V-1 */
    boolean isCycleDFS(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean ans = dfs(i, adj, visited,-1);
                if(ans) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, int parent) {
        visited[node] = true;
        for(int nbr : adj.get(node)) {
            if(!visited[nbr]) {
                boolean ans = dfs(nbr, adj, visited, node);
                if(ans) {
                    return true;
                }
                else if(visited[nbr] == true && nbr != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /* BFS */

    /* nodes 0:V-1  */
    boolean isCycleBFS(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean ans = bfs(i, adj, visited,parent);
                if(ans) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean bfs(int node, List<List<Integer>> adj, boolean[] visited, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int nbr : adj.get(curr)) {
                if(!visited[nbr]) {
                    q.offer(nbr);
                    visited[nbr] = true;
                    parent[nbr] = node;
                }
                else if(visited[nbr] == true && nbr != parent[node]) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Cycle_Detection_Revision {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        Helper_Cycle_Detection_Revision cdr = new Helper_Cycle_Detection_Revision();
        System.out.println(cdr.isCycleBFS(edges, V));
    }
}
