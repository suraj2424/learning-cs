import java.util.*;

class Solution {
    // Your Solution class code here
    List<Integer> topologicalSort(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int[] indg = new int[v];
        for(int i=0; i<v; i++) adj.add(new ArrayList<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indg[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++) {
            if(indg[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int parent = q.poll();
            ls.add(parent);
            for(int nbr : adj.get(parent)) {
                indg[nbr]--;
                if(indg[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }
        return ls;
    }
}

public class Topological_Sort_BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[][] edges = {
            {0,2},
            {1,2},
            {2,3},
            {2,4},
            {3,6},
            {5,4},
            {4,6}
        };
        int v = 7;
        List<Integer> ls = sol.topologicalSort(v, edges);
        System.out.println(ls);
        sc.close();
    }
}