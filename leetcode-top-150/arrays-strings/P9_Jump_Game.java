import java.util.*;

class Solution {
    // Your Solution class code here
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int jump = 0;
        for(int i=0; i<n; i++) {
            if(i > jump) return false;
            jump = Math.max(jump, i+nums[i]);
            if(jump >= n-1) return true;
        }
        return true;
    }
}

public class P9_Jump_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println("Can Jump: " + sol.canJump(nums)); // Expected: false
        sc.close();
    }
}