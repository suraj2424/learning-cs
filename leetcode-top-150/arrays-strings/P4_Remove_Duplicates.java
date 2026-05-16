import java.util.*;

class Solution {
    // Your Solution class code here
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 2, r = 2;
        while(r < n) {
            if(nums[l-2] == nums[r]) {
                r++;
            } else {
                nums[l++] = nums[r++];
            }
        }
        return l;
    }
}

public class P4_Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {1,1,1,2,2,2,3,3};
        int ans = sol.removeDuplicates(nums);
        System.out.println("answer: " + ans);
        System.out.println(Arrays.toString(nums));
        sc.close();
    }
}