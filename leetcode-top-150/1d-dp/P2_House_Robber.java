import java.util.*;

class Solution_P2_House_Robber {
    // Your LeetCode solution logic here
    public int rob(int[] nums) {
        /* Lets try BRUTE */
        // int n = nums.length;
        // int ans1 = 0;
        // for(int i=0; i<n; i+=2) {
        //     ans1 += nums[i];
        // }
        // int ans2 = 0;
        // for(int i=1; i<n; i+=2) {
        //     ans2 += nums[i];
        // }
        
        // return Math.max(ans1,ans2);


        // now lets proceed with something
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}

public class P2_House_Robber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P2_House_Robber sol = new Solution_P2_House_Robber();
        int[] house = {1,2,3,1};
        System.out.println("maximum money: " + sol.rob(house));
        
        sc.close();
    }
}