package codechef;
import java.util.*;
/* 

Codechef: Chef and Linear Chess
Difficulty: 1200
Link: https://www.codechef.com/problems/LINCHESS
Concept Used: Maths

*/
public class LINCHESS {
    /*
    
    Input:
    T: 2
    Case1:
    N:4 K:6
    [4,3,2,8]
    expected output: 3
    Case2:
    N: 4 K: 7
    [4,3,2,8]
    expected output: -1
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            int V = sc.nextInt();
            int[] A = new int[N];
            int min = Integer.MAX_VALUE;
            int num = -1;
            for(int i=0; i<N; i++) {
                A[i] = sc.nextInt();
                if(V % A[i] == 0) {
                    if(V/A[i] < min) {
                        min = V/A[i];
                        num = A[i];
                    }
                }
            }
            System.out.println(num);
        }
        sc.close();
    }
}
