import java.util.*;

class Solution_P3_Equal_Partition_Sum {
    // Your LeetCode solution logic here
    boolean equalPartition(int nums[]) {
        // code here
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        
        if(totalSum % 2 == 1) return false;
        
        int sum = totalSum/2;
        
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

public class P3_Equal_Partition_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P3_Equal_Partition_Sum sol = new Solution_P3_Equal_Partition_Sum();
        // int[] nums = {1,3,7,11}; // true
        int[] nums = {1,3,6,11}; // false
        System.out.println("can be partitioned: " + sol.equalPartition(nums));
        
        sc.close();
    }
}