import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

public class P22_Find_Index_Of_First_Occurrence_In_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("answer: " + sol.strStr(haystack, needle));
        sc.close();
    }
}