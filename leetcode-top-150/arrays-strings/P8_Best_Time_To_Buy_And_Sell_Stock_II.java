import java.util.*;

class Solution {
    // Your Solution class code here
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int total_profit = 0;
        int prev = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(max_profit < prices[i] - prev) {
                max_profit = prices[i] - prev;
                prev = Integer.MAX_VALUE;
            }
            total_profit = Math.max(total_profit, total_profit + max_profit);
            max_profit = 0;
            prev = Math.min(prev, prices[i]);
        }
        return total_profit;
    }
}

public class P8_Best_Time_To_Buy_And_Sell_Stock_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices)); // Expected Output: 7
        sc.close();
    }
}