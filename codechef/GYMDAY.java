package codechef;
import java.util.*;

/*

codechef: International Gym Day
Difficulty: 1201
Link: https://www.codechef.com/problems/GYMDAY

T
D Y X
Input:
3
2 2 2
5 40 38
3 26 15

*/
public class GYMDAY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean flag = false;

            for (int i = 0; i <= y; i++) {
                double discount = Math.min(i * d, 100);
                double discounted_cost = x * (100 - discount) / 100.0;
                if (discounted_cost <= y - i) {
                    System.out.println(i);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
