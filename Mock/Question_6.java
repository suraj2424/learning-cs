import java.util.*;

class Solution {
    // Your Solution class code here
    int[] findMaxArea(int[] heights) {
        int n = heights.length;
        int min = 0;
        int maxArea = 0;
        int s_index = 0;
        int e_index = 0;
        for(int i=0; i<n; i++) {
            min = heights[i];
            for(int j=i+1; j<n; j++) {
                for(int k=i; k<=j; k++) {
                    if(heights[k] <= min) {
                        min = heights[k];
                    }
                }
                if(min * (j-i+1) > maxArea) {
                    maxArea = min * (j-i+1);
                    s_index = i;
                    e_index = j;
                }
            }

        }
        return new int[]{maxArea, s_index, e_index};
    }

    // fixed brute force
    int findMaxArea_bruteFixed(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int minHeight = 0;
        int currArea = 0;
        for(int i=0; i<n; i++) {
            minHeight = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                currArea = minHeight * (j-i+1);
                maxArea = Math.max(currArea, maxArea);
            }
        }
        return maxArea;

    }

    // Optimized Approach (using stack)
    int findMaxArea_1(int[] heights) {
        int n = heights.length;
        int curr = 0, h = 0, r = 0, l = 0, width = 0, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=n; i++) {
            curr = (i == n ? 0 : heights[i]);
            while(!st.isEmpty() && curr < heights[st.peek()]) {
                h = heights[st.pop()];
                r = i;
                l = st.isEmpty() ? -1 : st.peek();
                width = r - l - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }
        return maxArea;
    }

}

public class Question_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] heights = {2,1,5,6,2,3};
        int ans = sol.findMaxArea_1(heights);
        System.out.println("Max area: " + ans);
        sc.close();
    }
}