import java.util.*;

class Solution_P1_Climbing_Stairs {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

public class P1_Climbing_Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P1_Climbing_Stairs sol = new Solution_P1_Climbing_Stairs();
        int n = 3;
        System.out.println("number of ways: " + sol.climbStairs(n)); // Expected: 3
        
        sc.close();
    }
}