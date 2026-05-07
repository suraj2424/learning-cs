import java.util.*;

class Solution {
    /* Print Name 'n' times */
    void printName(String s, int n) {
        if(n == 0) {
            return;
        }
        printName(s, n-1);
        System.out.print(n + " " + s + "\n");
    }

    /* Print from start=1 to end=N for N  */
    void printNumber(int n) {
        if(n == 0) return;
        printNumber(n-1);
        System.out.println(n);
    }

    /* Sum of first N numbers  */
    /* Functional */
    int sumFirstN(int n) {
        if(n == 0) return 0;
        return n + sumFirstN(n-1);
    }

    /* Sum first N numbers */
    /* Parameterised */
    int sumFirstN_Paremeterised(int n, int sum) {
        if (n == 0) return sum;
        return sumFirstN_Paremeterised(n-1, sum+n);
    }

    /* reverse an array */
    void reverseArray(int[] nums, int i) {
        if(i >= nums.length/2) return;
        int tmp = nums[i];
        nums[i] = nums[nums.length-1-i];
        nums[nums.length-1-i] = tmp;
    }

    boolean checkPalindrome(String s, int i){
        if(i>s.length()/2) return true;
        return s.charAt(i) == s.charAt(s.length()-1-i) && checkPalindrome(s, i+1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Solution sol = new Solution();
        
        /* Print name=Suraj `n` times */
        // String s = "Suraj";
        // int n = 5;
        // sol.printName(s, n);

        /* Print ascending number from 1 to n2 */
        // int n2 = 5;
        // sol.printNumber(n2);

        /* Sum of first N numbers */
        // int n3 = 5;
        // int ans1 = sol.sumFirstN(n3);
        // System.out.println("first n: " + n3 + " is: " + ans1);

        
        /* Parameterised sum of first N numbers */
        // int n4 = 5;
        // int ans2 = sol.sumFirstN_Paremeterised(n4, 0);
        // System.out.println("first n: " + n4 + " is: " + ans2);


        // int[] nums = {1,2,3,4};
        // System.out.println("initial array: " + Arrays.toString(nums));
        // sol.reverseArray(nums, 0);
        // System.out.println("reverse array: " + Arrays.toString(nums));


        String s = "racecar";
        System.out.println(sol.checkPalindrome(s, 0));





        sc.close();
    }
}