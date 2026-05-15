import java.util.*;

class Solution {
    // Your Solution class code here
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j=1; j<n; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

public class P3_Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans = sol.removeDuplicates(nums);
        System.out.println("answer: " + ans);
        sc.close();
    }
}