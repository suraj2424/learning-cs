package Topics.Graphs;
import java.util.*;
class Helper_Knight_Probability{
    double findProbability(int n, int row, int column, int k) {
        double[][][] dp = new double[k+1][n][n];
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
        dp[0][row][column] = 1.0;
        for(int steps=1; steps<=k; steps++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dp[steps-1][i][j] > 0) {
                        for(int[] dir : dirs) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if(ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[steps][ni][nj] += dp[steps-1][i][j] * (1.0 / 8);
                            }
                        }
                    }
                }
            }
        }
        double prob = 0.0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                prob += dp[k][i][j];
            }
        }
        return prob;
    }
}
public class Knight_Probability_In_ChessBoard {
    public static void main(String[] args) {
        Helper_Knight_Probability hkp = new Helper_Knight_Probability();
        int[] n = {3,1};
        int[] k = {2,0};
        int[] rows = {0,0};
        int[] cols = {0,0};
        for(int i=0; i<n.length; i++) {
            System.out.println("Knight Probability: " + " for n=" + n[i] + " at position: (" + rows[i] + "," + cols[i] + "): " + hkp.findProbability(n[i], rows[i], cols[i], k[i]));
        }
    }
}
