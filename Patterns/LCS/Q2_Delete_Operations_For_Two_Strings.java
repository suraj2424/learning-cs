import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return m+n-2*dp[m][n]; 
    }
}

public class Q2_Delete_Operations_For_Two_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("minimum deletions: " + sol.minDistance(word1, word2));
        sc.close();
    }
}