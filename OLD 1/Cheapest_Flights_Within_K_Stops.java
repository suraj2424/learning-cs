import java.util.*;
class Pair2 implements Comparable<Pair2> {
    int v;
    int w;
    int s;
    public Pair2(int v, int w, int s) {
        this.v = v;
        this.w = w;
        this.s = s;
    }
    public int compareTo(Pair2 o) {
        return this.w - o.w;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair2>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] f : flights) {
            graph.get(f[0]).add(new Pair2(f[1], f[2], 0));
        }

        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.offer(new Pair2(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            Pair2 curr = pq.poll();
            int u = curr.v, cost = curr.w, stops = curr.s;

            if (u == dst) return cost;

            if (stops == k + 1) continue;

            for (Pair2 nei : graph.get(u)) {
                int v = nei.v;
                int newCost = cost + nei.w;
                int newStops = stops + 1;

                if (newCost < dist[v][newStops]) {
                    dist[v][newStops] = newCost;
                    pq.offer(new Pair2(v, newCost, newStops));
                }
            }
        }
        return -1;
    }
}

public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        int result = sol.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price: " + result); // Output: Cheapest price: 200
    }
}
