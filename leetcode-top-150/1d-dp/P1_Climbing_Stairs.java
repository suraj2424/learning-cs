import java.util.*;

class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
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
        Solution sol = new Solution();
        int n = 5;
        System.out.println("climbing stairs: " + sol.climbStairs(n));
        sc.close();
    }
}