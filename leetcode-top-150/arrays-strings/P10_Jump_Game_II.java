import java.util.*;

class Solution {
    // Your Solution class code here
    int jump(int[] nums) {
        int n = nums.length;

        int currEnd = 0;
        int farthest = 0;
        int totalJumps = 0;
        for(int i=0; i<n-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currEnd) {
                totalJumps++;
                currEnd = farthest;
            }
        }
        return totalJumps;
    }
}

public class P10_Jump_Game_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println("Total Jumps: " + sol.jump(nums));
        sc.close();
    }
}