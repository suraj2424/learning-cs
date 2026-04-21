package Topics.Graphs;
import java.util.*;
class Helper_Reorder_Routes {
    void dfs(int src, List<List<Integer>> forward, List<List<Integer>> backward, boolean[] visited, int[] ans) {
        visited[src] = true;
        for(int neighbor : forward.get(src)) {
            if(!visited[neighbor]) {
                ans[0]++;
                dfs(neighbor, forward, backward, visited, ans);
            }
        }
        for(int neighbor : backward.get(src)) {
            if(!visited[neighbor]) {
                dfs(neighbor, forward, backward, visited, ans);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();
        for(int i=0; i<n; i++) {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }
        for(int i=0; i<connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            forward.get(u).add(v);
            backward.get(v).add(u);
        }
        int[] ans = new int[1];
        boolean[] visited = new boolean[n];
        dfs(0, forward, backward, visited, ans);
        return ans[0];
    }
}
public class Reorder_Routes {
    public static void main(String[] args) {

        Helper_Reorder_Routes hrr = new Helper_Reorder_Routes();

        int n1 = 6;
        int[][] connections1 = {
            {0,1},
            {1,3},
            {2,3},
            {4,0},
            {4,5}
        };

        int output1 = hrr.minReorder(n1, connections1);
        System.out.println("Output1: " + output1); // expected: 3

        int n2 = 5;
        int[][] connections2 = {
            {1,0},
            {1,2},
            {3,2},
            {3,4}
        };

        int output2 = hrr.minReorder(n2, connections2);
        System.out.println("Output2: " + output2); // expected 2

    }
}
