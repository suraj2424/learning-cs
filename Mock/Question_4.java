import java.util.*;

class Solution {

    boolean isUnique(String s, int start, int end) {
        boolean[] visited = new boolean[128];
        for(int i=start; i<=end; i++) {
            char c = s.charAt(i);
            if(visited[c]) {
                return false;
            }
            visited[c] = true;
        }
        return true;
    }

    int longestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }


    // Brute Approach
    /* TC: O(N^2) SC: O(N)  */
    int longestSubstring_better(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=i; j<n; j++) {
                char c = s.charAt(j);
                if(set.contains(c)) break;
                set.add(c);
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    // Optimal
    int longestSubstring_optimal(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int s_index = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= s_index) {
                s_index = map.get(c) + 1;
            }
            maxLen = Math.max(maxLen, i - s_index + 1);
            map.put(c,i);
        }
        return maxLen;
    }
}

/*  

abca


*/

public class Question_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        String str = "abca";
        int ans = sol.longestSubstring_optimal(str);
        System.out.println("Longest substring without repeating characters: " + ans);
        sc.close();
    }
}