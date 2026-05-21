import java.util.*;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + s1.charAt(i - 1), 
                        dp[i][j - 1] + s2.charAt(j - 1)
                    );
                }
            }
        }

        return dp[m][n];
    }
}

public class Q3_Minimum_ASCII_Delete_Sum_For_Two_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String s1 = "delete";
        String s2 = "leet";
        System.out.println("minimum ascii deletion value: " + sol.minimumDeleteSum(s1, s2));
        sc.close();
    }
}