import java.util.*;

class Solution {
    // Your Solution class code here
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
    }
}

public class P1_Merge_Sorted_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        sol.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        sc.close();
    }
}