import java.util.*;

class Solution {
    // Your Solution class code here
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        int k = 0;
        while(i < n) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}

public class P2_Remove_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {3,2,2,3};
        int val = 3;
        sol.removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        sc.close();
    }
}