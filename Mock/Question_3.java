import java.util.*;

class Solution {
    // Your Solution class code here
    int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0, maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) sum += -1;
            else sum += 1;

            if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum,i);
            }

        }
        return maxLen;
    }

    int countMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) sum += 1;
            else sum +=-1;

            if(map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}

public class Question_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol2 = new Solution();
        int[] nums = {0,1,0};
        int ans = sol2.countMaxLength(nums);
        System.out.println("Count subarray with equals 0s and 1s: " + ans);
        sc.close();
    }
}