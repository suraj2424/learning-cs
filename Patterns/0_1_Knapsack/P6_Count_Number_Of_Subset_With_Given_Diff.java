import java.util.*;

class Solution_P6_Count_Number_Of_Subset_With_Given_Diff {
    // Your LeetCode solution logic here
    int countWithGivenDiff(int[] nums, int diff) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(Math.abs(diff) > sum || sum + diff % 2 == 1) {
            return 0;
        }

        int req = (sum + diff)/2;
        int[][] dp = new int[n+1][req+1];
        dp[0][0] = 1;
        
        
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=req; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][req];
    }
}

public class P6_Count_Number_Of_Subset_With_Given_Diff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P6_Count_Number_Of_Subset_With_Given_Diff sol = new Solution_P6_Count_Number_Of_Subset_With_Given_Diff();
        
        // Driver code logic goes here
        int[] nums = {1,1,2,3};
        int diff = 1;

        System.out.println("count: min diff subsets: " + sol.countWithGivenDiff(nums, diff));

        
        sc.close();
    }
}