import java.util.*;

class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                ans.append(letters[i]);
                num -= val[i];
            }
        }

        return ans.toString();
    }
}

public class P18_Integer_To_Roman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int n = 3749;
        System.out.println("Roman from Integer: " + sol.intToRoman(n));
        sc.close();
    }
}