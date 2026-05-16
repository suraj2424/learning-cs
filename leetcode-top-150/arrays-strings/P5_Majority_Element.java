import java.util.*;

class Solution {
    // Your Solution class code here
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int num = 0;
        for(int i=0; i<n; i++) {
            num = nums[i];
            count = 1;
            for(int j=i+1; j<n; j++) {
                if(num == nums[j]) count++;
            }
            if(count > n/2) return num;
        }
        return -1;
    }
}

public class P5_Majority_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        int ans = sol.majorityElement(nums);
        System.out.println("answer: " + ans);
        sc.close();
    }
}