package Topics.Graphs;
import java.util.*;
class BFS_Implementation {
    Map<Integer, List<Integer>> buildGraph(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = graph.length;
        for(int i=0; i<n; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return map;
    }
    void bfs(Map<Integer, List<Integer>> adj, int src) {
        int n = adj.size();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q =  new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int neighbor : adj.get(curr)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    } 
}
public class BFS{
    public static void main(String[] args) {
        int[][] graph = {
            {1,2}, {1,3}, {2,4}, {2,3}, {3,4}
        };
        BFS_Implementation bfsObject = new BFS_Implementation();
        Map<Integer, List<Integer>> adj = bfsObject.buildGraph(graph);
        bfsObject.bfs(adj, 1);

    }
}
