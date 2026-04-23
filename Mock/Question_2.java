import java.util.*;

class Solution {
    // Your Solution class code here
    int divisibleSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int rem = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        for(int i=0; i<n; i++) {
            sum += nums[i];
            rem = sum % k;
            if(freq.containsKey(rem)) {
                count += freq.get(rem);
            }
            
            freq.put(rem, freq.getOrDefault(rem,0)+1);
        }
        return count;
    }
}

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int count = sol.divisibleSubarrays(nums, k);
        System.out.println("count of subarrays: " + count);

        sc.close();
    }
}
