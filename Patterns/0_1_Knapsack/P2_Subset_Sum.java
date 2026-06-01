import java.util.*;

class Solution_P2_Subset_Sum {
    // Your LeetCode solution logic here
    boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]]  || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
}

public class P2_Subset_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P2_Subset_Sum sol = new Solution_P2_Subset_Sum();
        int[] nums = {2,1,7,3};
        int sum = 4;
        System.out.println("can subset sum be found: " + sol.isSubsetSum(nums, sum));
        
        sc.close();
    }
}