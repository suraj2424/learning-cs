package Topics.Recursion;
import java.util.*;

class Helper_Recursion_Basic {
    /*

    1. print Name 5 times
    2. print Linearly from 1 to N
    3. print from N to 1.
    4. print from 1 to N but BACKTRACKING
    5. print from N to 1 but BACKRACKING

     */

    void printName(int n) {
        if(n == 0) return;
        System.out.println("Suraj");
        printName(n-1);
    }

    void printNumberAsc(int i,int n) {
        if(i > n) return;
        System.out.print(i + " ");
        printNumberAsc(i+1, n);
    }

    void printNumberDesc(int n) {
        if(n < 1) return;
        System.out.print(n + " ");
        printNumberDesc(n-1);
    }

    void printNumberAscBacktracking(int i, int n) {
        if(i < 1) return;
        printNumberAscBacktracking(i-1, n);
        System.out.print(i + " ");
    }

    void printNumberDescBacktracking(int i, int n) {
        if(i > n) return;
        printNumberDescBacktracking(i+1, n);
        System.out.print(i + " ");
    }

}

class Helper_Recursion_2 {
    /* 
        
        * Parameterized And Functional Recursion *

        1. sum of first N numbers
        - functional
        - parameterised
    
    */

    // parameterized
    void sumFirstN_Parameterized(int n, int sum) {
        if(n < 1) {
            System.out.println("Sum (parameterized) : " + sum); 
            return;
        }
        sumFirstN_Parameterized(n-1, sum+n);
    }

    // functional
    int sumFirstN_Functional(int n) {
        if(n < 1) return 0;
        return n + sumFirstN_Functional(n-1);
    }

    // functional 
    // reverse an array
    void reverse(int[] nums, int i) {
        if(i >= nums.length/2) return;
        int temp = nums[i];
        nums[i] = nums[nums.length-1-i];
        nums[nums.length-1-i] = temp;
        reverse(nums, i+1);
    }

    // check palindrome string
    void checkPalindrome(String s, int i) {
        if(i >= s.length()) {
            System.out.println("Given string is palindrome");
            return;
        }
        if(s.charAt(i) != s.charAt(s.length()-1-i)) {
            System.out.println("Given string is not palindrome");
            return;
        }
        checkPalindrome(s, i+1);
    }
}

class Helper_Recursion_3{
    /*
    
    * Multiple Recursion Calls *
    1. Fibonacci Sequence

    */

    int fibonacci(int n) {
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /* RECURSION TREE */
    /*
                                                        ex. f(4)
                                                             |
                                                            / \
                                                          /     \
                                                        f(3)    f(2)
                                                          |       \
                                                         / \        \
                                                       /     \        \
                                                    f(2)    f(1)        \
                                                     |        |          \
                                                    / \       |           \
                                                   /   \     f(0)          \
                                                 f(1)  f(0)               / \
                                                                         /   \
                                                                        f(1) f(0)
        Here f(0) will return 0
             f(1) will return 1
             f(2) will return 1
             f(3) will return 2
             f(4) will return 3
    */
}

class Helper_Recursion_4 {
    void generateSubsequences(int[] nums, int i, List<Integer> ls) {
        if(i >= nums.length) {
            System.out.println(ls);
            return;
        }
        // take
        ls.add(nums[i]);
        generateSubsequences(nums, i+1, ls);

        // dont take
        ls.remove(ls.size()-1);
        generateSubsequences(nums, i+1, ls);
        
    }

    // Subsequence whose sum is K
    // prints all subsequences
    void printSubsequenceWhoseSumK(int N, int[] nums, int target) {
        List<Integer> ls = new ArrayList<>();
        printSubsequence(N, nums, target, ls, 0, 0);
    }
    void printSubsequence(int N, int[] nums, int target, List<Integer> ls, int sum, int index) {
        if(index == N){
            if(sum == target) {
                System.out.println(ls);
                return;
            }
            else {
                return;
            }
        }
        // take
        sum += nums[index];
        ls.add(nums[index]);
        printSubsequence(N, nums, target, ls, sum, index+1);

        // dont take
        sum -= nums[index];
        ls.remove(ls.size()-1);
        printSubsequence(N, nums, target, ls, sum, index+1);
    }

    
    // subsequence whose sum is K
    // prints only one subsequence
    void printSubsequenceWhoseSumK_Single(int N, int[] nums, int target) {
        List<Integer> ls = new ArrayList<>();
        printSubsequence_Single(N, nums, target, ls, 0, 0);
    }

    boolean printSubsequence_Single(int N, int[] nums, int target, List<Integer> ls, int i, int sum) {
        if(i == N) {
            if(sum == target) {
                System.out.println(ls);
                return true;
            }
            return false;
        }
        sum += nums[i];
        ls.add(nums[i]);
        if(printSubsequence_Single(N, nums, target, ls, i+1, sum) == true) return true;

        sum -= nums[i];
        ls.remove(ls.size()-1);

        if(printSubsequence_Single(N, nums, target, ls, i+1, sum) == true) return true;

        return false;
    }

    void subsequenceSumWhoseSumK_Count(int N, int[] nums, int target) {
        int count = subsequenceCount(N, nums, target,0, 0);
        System.out.println("There " + count + " subsequences whose sum is equals to target: "  + target);
    }
    int subsequenceCount(int N, int[] nums, int target, int i, int sum) {
        if(i == N) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        // take
        sum += nums[i];
        int take = subsequenceCount(N, nums, target, i+1, sum);

        // not take
        sum -= nums[i];
        int notTake = subsequenceCount(N, nums, target, i+1, sum);

        return take + notTake;
    }
}

public class Recursion {
    public static void main(String[] args) {
        
        /* 1 */

        // Helper_Recursion_Basic hrecursion = new Helper_Recursion_Basic();
        // hrecursion.printName(5);
        // hrecursion.printNumberAsc(1, 5);
        // hrecursion.printNumberDesc(5);
        // hrecursion.printNumberAscBacktracking(5, 5);
        // hrecursion.printNumberDescBacktracking(1, 5);


        /* 2 */
        // Helper_Recursion_2 hr2 = new Helper_Recursion_2();  
        // hr2.sumFirstN_Parameterized(5, 0);
        // int sum = hr2.sumFirstN_Functional(5);
        // System.out.println("Sum (functional) : " + sum);

        /* Reverse an array */
        // int[] nums = {1,2,3,4};
        // System.out.println("Array before sorting: " + Arrays.toString(nums));
        // hr2.reverse(nums, 0);
        // System.out.println("Array after sorting: " + Arrays.toString(nums));

        /* Check Palindrome of String */
        // String s = "racecar";
        // hr2.checkPalindrome(s, 0);


        /* 4 */
        Helper_Recursion_4 hr4 = new Helper_Recursion_4();
        int[] nums = {1,2,1};
        // List<Integer> ls = new ArrayList<>();
        // hr4.generateSubsequences(nums, 0, ls);


        /* this will print all subsequence matching sum equals K (target) */
        // hr4.printSubsequenceWhoseSumK(3, nums, 2); 


        /* this will print only one subsequence where sum equals target  */
        // hr4.printSubsequenceWhoseSumK_Single(3, nums, 2); 

        /* this will print total count of subsequences whose sum equals target */
        hr4.subsequenceSumWhoseSumK_Count(3, nums, 2);



    }
}
