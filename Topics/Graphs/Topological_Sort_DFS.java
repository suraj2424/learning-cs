import java.util.*;

class Solution {
    // Your Solution class code here
    void dfs(int source, List<List<Integer>> adj, boolean[] visited, Deque<Integer> dq) {
        visited[source] = true;
        for(int nbr : adj.get(source)) {
            if(!visited[nbr]) {
                dfs(nbr, adj, visited, dq);
            }
        }
        dq.addFirst(source);
    }
    List<Integer> topologicalSort(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) adj.add(new ArrayList<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[v];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited, dq);
            }
        }
        List<Integer> ls = new ArrayList<>();
        for(int num : dq) {
            ls.add(num);
        }
        return ls;
    }
}

public class Topological_Sort_DFS {
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