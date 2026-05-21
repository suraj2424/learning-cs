import java.util.*;

class Solution {
    /*
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] mo : memo) Arrays.fill(mo,-1);
        return lcs(text1,text2,m,n,0,0, memo);
    }
    int lcs(String t1, String t2, int m, int n, int i, int j, int[][] memo) {
        if(i == m || j == n) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(t1.charAt(i) == t2.charAt(j)) {
            memo[i][j] = 1 + lcs(t1,t2,m,n,i+1,j+1,memo);
            return memo[i][j];
        }
        memo[i][j] = Math.max(lcs(t1,t2,m,n,i+1,j,memo), lcs(t1,t2,m,n,i,j+1,memo));
        return memo[i][j];
    }
    */



    /* Bottom Up Approach  */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];

    }
}

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("lcs: " + sol.longestCommonSubsequence(text1, text2));
        sc.close();
    }
}