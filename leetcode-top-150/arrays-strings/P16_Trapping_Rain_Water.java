import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] p = new int[n];
        p[0] = height[0];
        for(int i=1; i<n; i++) {
            p[i] = Math.max(p[i-1], height[i]);
        }
        int[] s = new int[n];
        s[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            s[i] = Math.max(s[i+1], height[i]);
        }

        int ans = 0;
        int left, right, min;
        for(int i=0; i<n; i++) {
            left = (i>0) ? p[i-1] : 0;
            right = (i<n-1) ? s[i+1] : 0;
            min = Math.min(left,right);
            if(height[i] < min) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }
}

public class P16_Trapping_Rain_Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("maximum trapped water: " + sol.trap(height));
        sc.close();
    }
}