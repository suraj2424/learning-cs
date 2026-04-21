package Topics.Graphs;
import java.util.*;

class Pair_Steps{
    int u;
    int v;
    Pair_Steps(int u, int v) {
        this.u = u;
        this.v = v;
    }
}
class Helper_Steps_By_Knight{
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n){
        int[][] dirs = {
            {-2,-1},
            {-2,1},
            {-1,-2},
            {-1,2},
            {1,-2},
            {1,2},
            {2,-1},
            {2,1}
        };
        int x1 = knightPos[1]-1;
        int y1 = knightPos[0]-1;

        int x2 = targetPos[1]-1;
        int y2 = targetPos[0]-1;

        boolean[][] visited = new boolean[n][n];
        Queue<Pair_Steps> q = new LinkedList<>();
        q.offer(new Pair_Steps(x1, y1));
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair_Steps curr = q.poll();
                if(curr.u == x2 && curr.v == y2) {
                    return steps;
                }
                for(int j=0; j<8; j++) {
                    int xi = curr.u + dirs[j][0];
                    int yi = curr.v + dirs[j][1];
                    if(xi >= 0 && xi < n && yi >= 0 && yi < n && visited[xi][yi] == false) {
                        visited[xi][yi] = true;
                        q.offer(new Pair_Steps(xi, yi));
                    }
                }
            }
            steps++;
        }
        return -2;
    }
}
public class Steps_By_Knight {
    public static void main(String[] args) {
        int[] n = {3,6};
        int[][] knightPos = {
            {3,3},
            {4,5}
        };
        int[][] targetPos = {
            {1,2},
            {1,1}
        };
        Helper_Steps_By_Knight hsbk = new Helper_Steps_By_Knight();
        for(int i=0; i<n.length; i++) {
            int output = hsbk.minStepToReachTarget(knightPos[i], targetPos[i], n[i]);
            System.out.println("Knight will reach to target in: " + output + " steps.");
        }
    }
}
