package Topics.Graphs;
import java.util.*;
class Helper_Detect_Cycle_In_Undirected_Graph_DFS{
    boolean dfs(List<List<Integer>> adj, boolean[] visited, int src, int parent) {
        visited[src] = true;
        for(int neighbor : adj.get(src)) {
            if(!visited[neighbor]) {
                if(dfs(adj,visited,neighbor, src)) return true;
            }
            else if(visited[neighbor] == true && neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<V; i++) ls.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean ans = dfs(ls,visited, i, -1);
                if(ans) return true;
            }
        }
        return false;
    }
}
public class Cycle_Detection_DFS {
    public static void main(String[] args) {
        Helper_Detect_Cycle_In_Undirected_Graph_DFS hdciugd = new Helper_Detect_Cycle_In_Undirected_Graph_DFS();
        int V = 4;
        // int E = 4;
        int[][] edges = {
            {0,1},
            {0,2},
            {1,2},
            {2,3},
        };
        boolean ans = hdciugd.isCycle(V, edges);
        System.out.println("Is cycle exists: " + ans);
    }
}
