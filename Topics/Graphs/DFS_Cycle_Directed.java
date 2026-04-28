package Topics.Graphs;
import java.util.*;

class Solution {
    boolean dfs(int source, List<List<Integer>> graph, boolean[] visited, int[] currentPath) {
        visited[source] = true;
        currentPath[source] = 1;
        for(int nbr : graph.get(source)) {
            if(!visited[nbr]) {
                if(dfs(nbr, graph, visited, currentPath)) return true;
            }
            else if(currentPath[nbr] == 1) return true;

        }
        currentPath[source] = 0;
        return false;
    }
    boolean isCycleDFS_Directed(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        int[] currentPath = new int[n];
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited, currentPath);
    }
}

public class DFS_Cycle_Directed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int n = 4;
        int[][] edges = {
            {0,1},
            {1,2}, {2,0}, {2,3}
        };
        boolean ans = sol.isCycleDFS_Directed(n, edges);
        System.out.println(ans);
        sc.close();
    }
}