import java.util.*;

class Solution_P3_House_Robber {
    // Your LeetCode solution logic here
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}

public class P3_House_Robber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P3_House_Robber sol = new Solution_P3_House_Robber();
        
        // Driver code logic goes here
        int[] nums = {2,7,9,3,1};
        System.out.println("answer: " + sol.rob(nums)); // expected 12
        
        sc.close();
    }
}