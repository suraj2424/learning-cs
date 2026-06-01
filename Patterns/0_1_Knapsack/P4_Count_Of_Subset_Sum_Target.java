import java.util.*;

class Solution_P4_Count_Of_Subset_Sum_Target {
    // Your LeetCode solution logic here
    int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        
        
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        
        return dp[n][target];
    }
}

public class P4_Count_Of_Subset_Sum_Target {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P4_Count_Of_Subset_Sum_Target sol = new Solution_P4_Count_Of_Subset_Sum_Target();
        int[] nums = {1,2,3,11,7};
        int target = 11;
        System.out.println("count of total subsets with given target: " + sol.perfectSum(nums, target));
        
        sc.close();
    }
}