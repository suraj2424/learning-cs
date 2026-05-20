import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        for(int i=1; i<n; i++) {
            p[i] = nums[i] * p[i-1];
        }

        int[] s = new int[n];
        s[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            s[i] = s[i+1] * nums[i];
        }

        int[] ans = new int[n];
        ans[0] = s[1];
        ans[n-1] = p[n-2];
        for(int i=1; i<n-1; i++) {
            ans[i] = p[i-1] * s[i+1];
        }
        return ans;
    }
}

public class P13_Product_Of_Array_Except_Self {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
        sc.close();
    }
}