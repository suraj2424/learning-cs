import java.util.*;

class Solution_Q4_Print_LCS {
    // Your LeetCode solution logic here
    void printLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        String result = sb.reverse().toString();

        System.out.println("LCS of given two strings: s1=" + s1 + " and s2=" + s2 + " is: " + result);
    }
}

public class Q4_Print_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_Q4_Print_LCS sol = new Solution_Q4_Print_LCS();
        
        // Driver code logic goes here
        String s1 = "abcde";
        String s2 = "abghi";
        sol.printLCS(s1, s2);
        
        sc.close();
    }
}