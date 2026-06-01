import java.util.*;

class Solution_P1_Standard_Unbounded_Knapsack {
    // Your LeetCode solution logic here
    int maxProfit(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=W; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}

public class P1_Standard_Unbounded_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P1_Standard_Unbounded_Knapsack sol = new Solution_P1_Standard_Unbounded_Knapsack();
        
        // Driver code logic goes here
        int[] w = {1,2,4,5};
        int[] val = {1,4,5,7};
        int W = 7;
        System.out.println("answer: " + sol.maxProfit(w, val, W));
        
        sc.close();
    }
}