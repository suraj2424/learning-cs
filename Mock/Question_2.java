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
            if (rem < 0) rem += k;
            if(freq.containsKey(rem)) {
                count += freq.get(rem);
            }
            
            freq.put(rem, freq.getOrDefault(rem,0)+1);
        }
        return count;
    }

    /* Custom: k = 0  */
    int divisibleSubarrays_1(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int diff = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        for(int i=0; i<n; i++) {
            sum += nums[i];
            diff = sum - k;
            if(freq.containsKey(diff)) {
                count += freq.get(diff);
            }
            
            freq.put(sum, freq.getOrDefault(sum,0)+1);
        }
        return count;
    }

    int divisibleSubarrays_2(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int rem = 0;
        int[] freq = new int[k];
        freq[0] = 1;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            rem = sum % k;
            if (rem < 0) rem += k;
            if(freq[rem] != 0) {
                count += freq[rem];
            }
            
            freq[rem]++;
        }
        return count;
    }

    int divisibleSubarrays_3(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max_len = 0;
        int rem = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[k];
            rem = sum % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem)) {
                max_len = Math.max(max_len, i - map.get(rem));
            }
            map.put(rem, i);
        }
        return max_len;
    }
}

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int count = sol.divisibleSubarrays_3(nums, k);
        System.out.println("longest length of subarray: " + count);

        sc.close();
    }
}
