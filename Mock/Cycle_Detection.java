import java.util.*;

class Solution {
    // Your Solution class code here
    boolean dfs(int source, List<List<Integer>> graph, boolean[] visited, int parent) {
        visited[source] = true;
        for(int nbr : graph.get(source)) {
            if(!visited[nbr]) {
                if(dfs(nbr,graph,visited,source)) return true;
            }
            else if(visited[nbr] == true && parent != nbr) return true;
        }
        return false;
    }
    boolean isCycleDFS(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(0,graph, visited, -1);
    }

    boolean isCycleBFS(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int nbr : graph.get(curr)) {
                if(!visited[nbr]) {
                    parent[nbr] = curr;
                    visited[nbr] = true;
                    q.offer(nbr);
                }
                else if(visited[nbr] == true && parent[curr] != nbr) return true;
            }
        }
        return false;

    }
}

public class Cycle_Detection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int n = 4;
        int[][] edges = {
            {0,1},
            {1,2}, {2,3}
        };
        boolean ans = sol.isCycleBFS(n, edges);
        System.out.println(ans);
        sc.close();
    }
}