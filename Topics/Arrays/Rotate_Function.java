import java.util.*;

class Solution {
    // Your Solution class code here
    int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int initial = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            initial += (i * nums[i]);
        }
        int max = initial;
        int curr = 0;
        for(int i=1; i<n; i++) {
            curr = initial + sum - n * nums[n-i];
            max = Math.max(max, curr);
            initial = curr;
        }
        return max;
    }
}

public class Rotate_Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {4,3,2,6};
        System.out.println("Answer: " + sol.maxRotateFunction(nums));
        sc.close();
    }
}