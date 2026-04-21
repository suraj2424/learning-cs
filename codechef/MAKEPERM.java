package codechef;
import java.util.*;

/*

Codechef: Make Permutation
Difficulty: 1200
Link: https://www.codechef.com/problems/MAKEPERM
Concept Used: Maths/Greedy(ig)
ig --> i guess

Input:
T = 4

5
4 1 3 2 1
expected: YES
5
2 4 3 4 2
expected: NO
1
1
expected: YES
6
1 1 1 1 6 6
expected: NO
*/
public class MAKEPERM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            Arrays.sort(A);
            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (A[i] > i + 1) {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
        sc.close();
    }
}
