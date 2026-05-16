import java.util.*;

class Solution {
    /* Self Solved  */
    void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rem = new int[k];
        for(int l=0; l<k; l++) {
            rem[l] = nums[n-k+l];
        }
        int index = 0;
        for(int i=n-1; i>=k; i--) {
            nums[i] = nums[n-k-1-index];
            index++;
        }
        for(int i=0; i<k; i++) {
            nums[i] = rem[i];
        }
    }


    void reverse(int[] nums, int start, int end) {
        int tmp;
        while(start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }



}

public class P6_Rotate_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        sol.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        sc.close();
    }
}