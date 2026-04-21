package Topics.Graphs;
import java.util.*;
class DFS_Implementation {
    List<List<Integer>> buildGraph(int V, int[][] graph) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = graph.length;
        for(int i=0; i<V; i++) {
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        return ls;
    }
    void dfs(int V,int[][] grid, int src) {
        List<List<Integer>> adj = buildGraph(V, grid);
        boolean[] visited = new boolean[V];
        dfsUtil(adj,visited,src);
    } 
    void dfsUtil(List<List<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        System.out.print(src + " ");
        for(int neighbor : adj.get(src)) {
            if(!visited[neighbor]) {
                dfsUtil(adj, visited, neighbor);
            }
        }
    }
}
public class DFS{
    public static void main(String[] args) {
        int[][] graph = {
            {0,1}, {0,2}, {1,3}, {1,2}, {2,3}
        };
        DFS_Implementation dfsObject = new DFS_Implementation();
        System.out.print("DFS Order: ");
        dfsObject.dfs(4, graph, 0);
    }
}
