import java.util.*;

class Solution {
    // Your Solution class code here
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;
        int i = 0;
        int prev = Integer.MAX_VALUE;
        while(i < n) {
            maxP = Math.max(maxP, prices[i] - prev);
            prev = Math.min(prev, prices[i]);
            i++;
            
        }
        return maxP;
    }
}

public class P7_Best_Time_To_Buy_And_Sell_Stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices));
        sc.close();
    }
}