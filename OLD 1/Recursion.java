/* RECURSION

1. Parameterised
2. Functional

Multiple Recursion Calls
- Recursion Tree


*/


// Sum of first N number

import java.util.*;

class SumFirstN {
    // parameterised way
    int sumParameterised(int n, int sum) {
        if(n < 1) {
            return sum;
        }
        return sumParameterised(n-1, sum+n);
    }

    // functional
    int sumFunctional(int i) {
        if(i<1) {
            return 0;
        }
        return i + sumFunctional(i-1);
    }
}

// Reverse an Array

class ReverseArray{
    void reverseArray(int[] nums, int i) {
        if(i > nums.length/2) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[nums.length-1-i];
        nums[nums.length-1-i] = temp;
        reverseArray(nums, i+1);
    }
    void reverseArray2(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        reverseArray2(nums, l+1, r-1);
    }
}

/* Check if String is palindrome or not */
class CheckStringPalindrome{
    boolean checkPalindrome(String s, int i) {
        if(i > s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return checkPalindrome(s, i+1);
    }
}


/* Multiple Recursion Calls */

/* Fibonacci Number */
class Fibonacci{
    int fibonacci(int n) {
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}


/* 78. Subsets */

class Subsets_78_Leetcode{
    List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateSubsets(nums, ls, curr, 0);
        return ls;
    }
    void generateSubsets(int[] nums, List<List<Integer>> ls, List<Integer> curr, int idx) {
        if(idx == nums.length) {
            ls.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        generateSubsets(nums, ls, curr, idx+1);
        curr.remove(curr.size()-1);
        generateSubsets(nums, ls, curr, idx+1);
    }
}

class SubsequenceWithSumK{
    List<List<Integer>> sumSubSeq(int[] nums, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateKSum(nums, k, ls, curr, 0, 0);
        return ls;
    }
    void generateKSum(int[] nums, int k, List<List<Integer>> ls, List<Integer> curr, int idx, int sum) {
        if(idx >= nums.length) {
            if(sum == k) {
                ls.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(nums[idx]);
        generateKSum(nums, k, ls, curr, idx+1, sum+nums[idx]);
        curr.remove(curr.size()-1);
        generateKSum(nums, k, ls, curr, idx+1, sum);
    }
}

class SubsequenceWithSumEqualsSum{
    boolean sumSubSeqWithSumEqualsSum(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        return sumSubSeqSum(nums, k, ls, 0, 0);
    }
    boolean sumSubSeqSum(int[] nums, int k, List<Integer> ls, int idx, int sum) {
        if(idx >= nums.length) {
            if(sum == k) return true;
            else return false;
        }
        ls.add(nums[idx]);
        if(sumSubSeqSum(nums, k, ls, idx+1, sum+nums[idx]) == true) {
            return true;
        }
        ls.remove(ls.size()-1);
        if(sumSubSeqSum(nums, k, ls, idx+1, sum) == true) {
            return true;
        }
        return false;
    }
}


public class Recursion {
    public static void main(String[] args) {
        
        /* Sum of First N numbers */

        // SumFirstN s1 = new SumFirstN();
        // int ans = s1.sumParameterised(5, 0);
        // System.out.println("ans is: " + ans);
        // int ans2 = s1.sumFunctional(5);
        // System.out.println("ans of funtional recursion is: "+ ans2);





        /* Reverse an array */

        // ReverseArray ra1 = new ReverseArray();
        // SINGLE VARIABLE
        // int[] nums = {1,2,3,4,5,6,1};
        // System.out.println("initial array: " + Arrays.toString(nums));
        // ra1.reverseArray(nums, 0);
        // System.out.println("Array after reversing: " + Arrays.toString(nums));
        // DOUBLE VARIABLE
        // int[] nums = {1,2,3,4,5,6,1};
        // System.out.println("Initial array: " + Arrays.toString(nums));
        // ra1.reverseArray2(nums, 0, nums.length-1);
        // System.out.println("Reversed Array: "+ Arrays.toString(nums));



        /* Check if string is palindrome or not */
        // CheckStringPalindrome csp1 = new CheckStringPalindrome();
        // String str1 = "ALTERNATE";
        // String str2 = "RACECAR";
        // System.out.println("String: " + str1 + " is palindrome: " + csp1.checkPalindrome(str1, 0) + "\nString: " + str2 + " is palindrome: " + csp1.checkPalindrome(str2, 0));



        /* Fibonacci Number */
        // Fibonacci fn = new Fibonacci();
        // int n = 7;
        // System.out.println("Fibonaccin number for n: " + n + " is: " + fn.fibonacci(n));



        /* LEETCPDE: 78. SUBSETS */
        // int[] nums = {3,1,2};
        // Subsets_78_Leetcode sb1 = new Subsets_78_Leetcode();
        // List<List<Integer>> ls = sb1.findSubsets(nums);
        // System.out.println(ls);


        /* Subsequences with Sum K */
        // int[] nums = {1,2,1,3};
        // SubsequenceWithSumK sws1 = new SubsequenceWithSumK();
        // List<List<Integer>> ls = sws1.sumSubSeq(nums, 2);
        // System.out.println(ls);


        /* Subsequence with Sum equal to Sum */
        SubsequenceWithSumEqualsSum swses = new SubsequenceWithSumEqualsSum();
        int[] nums = {1,2,3,4,5};
        int k = 5;
        boolean ans = swses.sumSubSeqWithSumEqualsSum(nums, k);
        System.out.println("ans is: " + ans);



    }
    
}
