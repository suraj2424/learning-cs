package codechef;
import java.util.*;
/*

Codechef: Append for OR
Difficulty: 1201
Link: https://www.codechef.com/problems/APPENDOR

Concept Used: Bitwise's

Input:
T: 4

case1:
4 15
3 5 6 2
e: 8

case2:
3 8
1 2 1
e: -1

case3:
1 1
0
e: 1

case4:
5 7
1 2 4 2 1
e: 0

*/
public class APPENDOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int target = sc.nextInt();
            int or = 0;
            for(int i=0; i<n; i++) {
                int num = sc.nextInt();
                or |= num;
            }
            if((or | target) != target) {
                System.out.println(-1);
            }
            else {
                int xor = target ^ or;
                System.out.println(xor);
            }
        }
        sc.close();
    }
}
