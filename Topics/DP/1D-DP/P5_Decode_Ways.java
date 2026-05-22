import java.util.*;

class Solution_P5_Decode_Ways {
    // Your LeetCode solution logic here
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        int dp2 = 1;
        int dp1 = 1;
        for(int i=1; i<s.length(); i++) {
            int curr = 0;
            if(s.charAt(i) != '0') {
                curr += dp1;
            }

            String str = s.substring(i-1,i+1);
            int val = Integer.parseInt(str);
            if(val >= 10 && val <= 26) {
                curr += dp2;
            } 

            dp2 = dp1;
            dp1 = curr;
        }
        return dp1;
    }
}

public class P5_Decode_Ways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_P5_Decode_Ways sol = new Solution_P5_Decode_Ways();
        
        // Driver code logic goes here
        String s = "2101";
        System.out.println("answer: " + sol.numDecodings(s));

        
        sc.close();
    }
}