import java.util.*;

class Solution_P4_House_Robber_II {
    // Your LeetCode solution logic here
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        for(int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], nums[i] + dp1[i-2]);
        }
        int[] dp2 = new int[n];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], nums[i] + dp2[i-2]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}

public class P4_House_Robber_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P4_House_Robber_II sol = new Solution_P4_House_Robber_II();
        
        // Driver code logic goes here
        int[] nums = {2,3,2};
        System.out.println("max money robbed: " + sol.rob(nums));
        
        sc.close();
    }
}