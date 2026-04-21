package codechef;
import java.util.*;
/*

Codechef: Airplane Management
Difficulty: 1201
Link: https://www.codechef.com/problems/AIRM
concept used: Event Counting / Frequency Aggregation

Input:
T = 3

N = 3
A[] = 1 1 2
D[] = 2 2 3
expected: 3

4
1 5 4 3
4 6 10 4
expected:3

3
1 4 3
2 6 5
expected: 1

*/
public class AIRM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] d = new int[n];
            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++) {
                d[i] = sc.nextInt();
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0)+1);
                map.put(d[i], map.getOrDefault(d[i], 0)+1);
            }
            int max = 0;
            for(int val : map.values()) {
                max = Math.max(max, val);
            }
            System.out.println(max);
        }
        sc.close();
    }
}
