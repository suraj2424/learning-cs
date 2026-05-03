import java.util.*;

class Pair {
    int v;
    int weight;
    Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

class Solution {
    // Your Solution class code here
    void dijkstra(int v, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }
        int INF = (int)1e9;
        int[] dist = new int[v];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        q.offer(new Pair(0,0));
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.v;
            int weight = curr.weight;
            if(dist[u] < weight) continue;
            for(Pair nbr : adj.get(u)) {
                if(weight + nbr.weight < dist[nbr.v]) {
                    dist[nbr.v] = weight + nbr.weight;
                    q.offer(new Pair(nbr.v, dist[nbr.v]));
                }
            }
        }
        System.out.print("[");;
        for(int i=0; i<v; i++) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
        System.out.println();
        System.out.println(Arrays.toString(dist));
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[][] edges = {
            {0,1,4},
            {0,2,8},
            {1,4,6},
            {2,3,2},
            {3,4,10},
        };
        int v = 5;
        sol.dijkstra(v, edges);
        sc.close();
    }
}