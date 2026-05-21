import java.util.*;

class Solution {
    public int romanToInt(String s) {
        String letters = "IVXLCDM";
        int[] val = {1,5,10,50,100,500,1000};
        int n = s.length();
        int index = 0;
        char c = 'A';
        char prevChar = 0;
        int prevIndex = 0;
        int ans = val[letters.indexOf(s.charAt(n-1))];
        for(int i=n-2; i>=0; i--) {
            c = s.charAt(i);
            index = letters.indexOf(c);
            prevChar = s.charAt(i+1);
            prevIndex = letters.indexOf(prevChar);
            if(prevIndex > index) {
                ans -= val[index];
            } else {
                ans += val[index];
            }
        }
        return ans;
    }
}

public class P17_Roman_To_Integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String s = "MCMXCIV";
        System.out.println("integeer: " + sol.romanToInt(s));
        sc.close();
    }
}