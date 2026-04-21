package Topics.Graphs;
import java.util.*;
class Graph_Implementation1 {
    static void printGraph(Map<Integer, List<Integer>> adj) {
        // apply entry on map
        for(Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            int key = entry.getKey();
            // List<Integer> value = entry.getValue();
            System.out.print("Node " + key + " Neighbors: ");
            for(int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    static Map<Integer, List<Integer>> buildGraph(int[][] graph) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = graph.length;
        for(int i=0; i<n; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return adj;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1,2}, {1,3}, {2,4}, {2,3}, {3,4}
        };
        
        Map<Integer, List<Integer>> adj = buildGraph(graph);
        printGraph(adj);

    }
}