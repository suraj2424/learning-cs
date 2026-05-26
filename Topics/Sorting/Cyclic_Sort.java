import java.util.*;

class Solution_Cyclic_Sort {
    void sort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            while(i != nums[i]-1) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
            i++;
        }
    }
}

public class Cyclic_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_Cyclic_Sort sol = new Solution_Cyclic_Sort();
        
        // Driver code logic goes here
        int[] nums = {3,5,2,1,4};
        sol.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        sc.close();
    }
}