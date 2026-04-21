import java.util.*;

public class BellmanFord {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;  this.v = v;  this.w = w;
        }
    }

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