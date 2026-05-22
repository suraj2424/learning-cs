import java.util.*;

class Solution_P2_Min_Cost_Climbing_Stairs {
    // Your LeetCode solution logic here
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        if(n == 2) return Math.min(cost[0], cost[1]); 
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=n; i++) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2]+dp[i-2]);
        }
        return dp[n];
    }
}

public class P2_Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P2_Min_Cost_Climbing_Stairs sol = new Solution_P2_Min_Cost_Climbing_Stairs();
        
        // Driver code logic goes here
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("min cost: " + sol.minCostClimbingStairs(cost)); // Expected: 6
        
        sc.close();
    }
}