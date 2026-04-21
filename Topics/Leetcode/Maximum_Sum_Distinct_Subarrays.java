package Topics.Leetcode;
import java.util.*;

/*

LEETCODE
2461. Maximum Sum of Distinct Subarrays With Length K
Difficulty: Medium
Concept: Sliding Window

*/
class Helper_Maximum_Sum_Distinct_Subarrays {
    long findMax(int[] nums, int k) {

        /* Generate subarrays of size K */

        // int n = nums.length;
        // List<List<Integer>> res = new ArrayList<>();
        // for(int i=0; i<=n-k; i++) {
        //     List<Integer> ls = new ArrayList<>();
        //     for(int j=i; j<i+k;j++) {
        //         ls.add(nums[j]);
        //     }
        //     res.add(ls);
        // }
        // for(List<Integer> ar : res) {
        //     System.out.println(ar);
        // }

        int n = nums.length;
        long max = 0;
        for(int i=0; i<=n-k; i++) {
            HashSet<Integer> set = new HashSet<>();
            long currSum = 0;
            for(int j=i; j<i+k; j++) {
                set.add(nums[j]);
                currSum += nums[j];
            }
            if(set.size() == k) {
                max = Math.max(max, currSum);
            }
        }
        return max;
    }
}


public class Maximum_Sum_Distinct_Subarrays {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        Helper_Maximum_Sum_Distinct_Subarrays msds = new Helper_Maximum_Sum_Distinct_Subarrays();
        long ans = msds.findMax(nums, k);
        System.out.println("Answer is: " + ans);
    }
}
