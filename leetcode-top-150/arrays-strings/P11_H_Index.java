import java.util.*;

class Solution {
    void reverse(int[] citations) {
        int n = citations.length;
        int tmp = 0;
        for(int i=0; i<n/2; i++) {
            tmp = citations[i];
            citations[i] = citations[n-1-i];
            citations[n-1-i] = tmp;    
        }
    }
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        reverse(citations);
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(citations[i] >= i+1) {
                ans = i+1;
            }
        }
        return ans;
    }
}

public class P11_H_Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] citations = {3,0,6,1,5};
        System.out.println("at least citations referred: " + sol.hIndex(citations));
        sc.close();
    }
}