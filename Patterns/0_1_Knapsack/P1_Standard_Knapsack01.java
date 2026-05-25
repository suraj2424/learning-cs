import java.util.*;

class Solution_P1_Standard_Knapsack01 {
    // Your LeetCode solution logic here
    int maxProfit(int[] w, int[] val, int W) {
        int n = w.length-1;
        int[][] memo = new int[n+1][W+1];
        for(int[] m : memo) {
            Arrays.fill(m,-1);
        }
        return helper_maxProfit(w,val,W,n, memo);
    }
    int helper_maxProfit(int[] w, int[] val, int W,int i, int[][] memo) {
        if(i < 0 || W == 0) return 0;
        if(memo[i][W] != -1) {
            return memo[i][W];
        }
        // take
        int take = 0;
        if(w[i] <= W){
            take = val[i] + helper_maxProfit(w,val,W-w[i],i-1,memo);
        }

        int dont = helper_maxProfit(w, val, W, i-1,memo);

        memo[i][W] = Math.max(take,dont);
        return memo[i][W];
    }

    int maxProfit2(int[] wt, int[] val, int W) {
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
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}

public class P1_Standard_Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P1_Standard_Knapsack01 sol = new Solution_P1_Standard_Knapsack01();
        
        // Driver code logic goes here
        int[] w = {1,3,4,5};
        int[] val = {1,4,5,7};
        int W = 7;
        System.out.println("max profit: " + sol.maxProfit(w, val, W));
        

        // Iterative answer
        System.out.println("Iterative max profit: " + sol.maxProfit2(w, val, W));
        

        sc.close();
    }
}