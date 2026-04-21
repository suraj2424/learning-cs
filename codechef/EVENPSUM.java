package codechef;
import java.util.*;
/*

Codechef: Even Pair Sum
Difficulty: 1200
Link: https://www.codechef.com/problems/EVENPSUM

Concept Used: Maths

Input:
T = 4
case1:
A = 1, B = 1
expected output: 1

case2:
A = 2, B = 3
expected output: 3

case3:
A = 4, B = 6
expected output: 12

case4:
A = 8, B = 9
expected output: 36


*/

public class EVENPSUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int eA = A/2;
            int eB = B/2;
            int oA = (A+1)/2;
            int oB = (B+1)/2;
            long ans = (long) eA * eB + (long) oA * oB;
            System.out.println(ans);
        }
        sc.close();
    }
}
