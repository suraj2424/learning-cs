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
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        
        // String s = "Suraj";
        // int n = 5;
        // sol.printName(s, n);


        // int n2 = 5;
        // sol.printNumber(n2);

        // int n3 = 5;
        // int ans1 = sol.sumFirstN(n3);
        // System.out.println("first n: " + n3 + " is: " + ans1);

        int n4 = 5;
        int ans2 = sol.sumFirstN_Paremeterised(n4, 0);
        System.out.println("first n: " + n4 + " is: " + ans2);




        sc.close();
    }
}