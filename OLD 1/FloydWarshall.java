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

        System.out.println("All pairs shortest distances:");
        for (int[] row : dist) {
            for (int d : row)
                System.out.print((d >= INF ? "INF" : d) + "\t");
            System.out.println();
        }
    }
}