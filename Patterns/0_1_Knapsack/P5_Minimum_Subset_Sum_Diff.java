import java.util.*;

class Solution_P5_Minimum_Subset_Sum_Diff {
    // Your LeetCode solution logic here
    int minDifference(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

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

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++) {
            if(dp[n][i]) {
                min  = Math.min(min, sum - 2 * i);
            }
        }

        return min;
    }
}

public class P5_Minimum_Subset_Sum_Diff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P5_Minimum_Subset_Sum_Diff sol = new Solution_P5_Minimum_Subset_Sum_Diff();
        
        // Driver code logic goes here

        int[] nums = {1,6,1,1,5};
        System.out.println("min absolute subset diff: " + sol.minDifference(nums));
        
        sc.close();
    }
}