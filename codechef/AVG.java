package codechef;
import java.util.*;

/*

codechef: Average Number
difficulty: 1202
Link: https://www.codechef.com/problems/AVG

Input type:
t
n k v
a1, ... , an

t -> no of testcases
n - elements
k - elements removed
v - total average

Input:
3
3 3 4
2 7 3
3 1 4
7 6 5
3 3 4
2 8 3

*/

public class AVG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int v = sc.nextInt();
            long sum = 0;
            for(int i=0; i<n; i++) {
                int num = sc.nextInt();
                sum += num;
            }
            
            long rem = (v * (n+k) - sum);
            
            if(rem > 0 && rem % k == 0) {
                System.out.println(rem / k);
            }
            else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
