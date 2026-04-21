import java.util.*;

class Helper_Question_1 {
    // Your Solution class code here

    // Iteration 1: Wrong Assumption
    // I thought subarray size is K
    // but in fact, subarray size can be anything and sum should be equal to k.
    int countSubarrays_1(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = k; i < n; i++) {
            if (sum == k) {
                count++;
            }
            sum -= nums[i - k];
            sum += nums[i];
        }
        return count;
    }

    // sliding window
    int countSubarrays_2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int s = 0, e = 0;
        int sum = 0;
        while (e < n) {
            sum += nums[e];
            while (sum > k) {
                sum -= nums[s];
                s++;
            }
            if (sum == k)
                count++;
            e++;
        }
        return count;
    }

    int countSubarrays_3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Helper_Question_1 sol1 = new Helper_Question_1();
        int[][] nums = {
                { 1, 1, 1 },
                { -1, 1, 0 },
                { 3 },
                { 1, 2, 3 },
                { 2, 2, 2 },
                { 1, 2, 3 },
                { 0, 0, 0 },
                { 3, 4, 7, 2, -3, 1, 4, 2 }
        };
        int[] k = { 2, 0, 3, 7, 6, 3, 0, 7 };
        int[] expected = { 2, 3, 1, 0, 1, 2, 6, 4 };

        // Iteration 1
        // System.out.println(sol1.countSubarrays_1(nums, k));

        // Iteration 2
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Case " + (i + 1));
            System.out.println("nums: " + Arrays.toString(nums[i]));
            System.out.println("k: " + k[i]);
            System.out.println("Output: " + sol1.countSubarrays_3(nums[i], k[i]));
            System.out.println("Expected: " + expected[i]);
            System.out.println();
        }

        sc.close();
    }
}