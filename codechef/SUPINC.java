package codechef;
import java.util.*;

/*

codechef: Superincreasing
Difficulty: 1201
Link: https://www.codechef.com/problems/SUPINC
Concept used: Bitwise

Input:
T:4

case1:
N:3  K: 2  X: 3
expected: YES

case2:
3 3 3
expected: NO

case3:
5 3 6
expected: YES

case4:
6 2 1
expected: NO

*/

public class SUPINC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            long X = (long) x;
            if(k > 30) {
                System.out.println("No");
            }
            else {
                long minValue = 1l << (k-1);

                if(X >= minValue) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}
