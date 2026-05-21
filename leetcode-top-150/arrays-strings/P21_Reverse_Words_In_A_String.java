import java.util.*;

class Solution {
    void reverse(String[] words) {
        int n = words.length;
        String tmp = "";
        for(int i=0; i<n/2; i++) {
            tmp = words[i];
            words[i] = words[n-1-i];
            words[n-1-i] = tmp;
        }
    } 
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        reverse(words);
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        String curr = "";
        for(int i=0; i<n-1; i++) {
            curr = words[i].trim();
            if(words[i].length() != 0) {
                sb.append(words[i] + " ");
            }
        }
        if(words[n-1].trim().length() != 0) {
            sb.append(words[n-1]);
        }
        return sb.toString();
    }

    public static String reverseWordsExpected(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        int index = length - 1;

        char[] result = new char[length];
        int resultIndex = 0;

        while (index >= 0) {

            // Skip trailing/multiple spaces
            while (index >= 0 && chars[index] == ' ') {
                index--;
            }

            if (index < 0) {
                break;
            }

            int wordEnd = index;

            // Find the beginning of the word
            while (index >= 0 && chars[index] != ' ') {
                index--;
            }

            int wordStart = index + 1;

            // Add space before next word
            if (resultIndex != 0) {
                result[resultIndex++] = ' ';
            }

            // Copy word into result
            for (int i = wordStart; i <= wordEnd; i++) {
                result[resultIndex++] = chars[i];
            }
        }

        return new String(result, 0, resultIndex);
    }
}

public class P21_Reverse_Words_In_A_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String s = "a good   example";
        System.out.println("reversed words in a string: " + sol.reverseWordsExpected(s));
        sc.close();
    }
}