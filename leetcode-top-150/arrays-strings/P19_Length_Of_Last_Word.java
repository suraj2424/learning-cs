import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length-1].length();
    }
}

public class P19_Length_Of_Last_Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String s = "   fly me   to   the moon  ";
        System.out.println("length of last word: " + sol.lengthOfLastWord(s));
        sc.close();
    }
}