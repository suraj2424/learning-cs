import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        /* Approach 1 */
        // int n = strs.length;
        // Arrays.sort(strs);
        // char[] c1 = strs[0].toCharArray();
        // char[] c2 = strs[n-1].toCharArray();
        // StringBuilder sb = new StringBuilder();
        // for(int i=0; i<c1.length; i++) {
        //     if(c1[i] != c2[i]) break;
        //     sb.append(c1[i]);
        // }
        // return sb.toString();

        /* Approach 2 */
        int n = strs.length;
        String pref = strs[0];
        for(int i=1; i<n; i++) {
            while(strs[i].indexOf(pref) != 0) {
                pref = pref.substring(0, pref.length()-1);
            }
        }
        return pref;
    }
}

public class P20_Longest_Common_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println("longest common prefix: " + sol.longestCommonPrefix(strs));
        sc.close();
    }
}