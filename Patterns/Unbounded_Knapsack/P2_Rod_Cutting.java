import java.util.*;

class Solution_P2_Rod_Cutting {
    // Your LeetCode solution logic here
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i <= j) {
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}

public class P2_Rod_Cutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P2_Rod_Cutting sol = new Solution_P2_Rod_Cutting();
        
        // Driver code logic goes here
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("answer: " + sol.cutRod(price));
        
        sc.close();
    }
}