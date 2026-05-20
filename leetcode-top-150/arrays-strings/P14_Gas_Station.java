import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int lowest_idx = 0;
        int currGas = 0;
        int currCost = 0;
        int gasAtI = 0;
        for(int i=0; i<n; i++) {
            gasAtI = gas[i] - cost[i];
            currCost += gasAtI;
            currGas += gasAtI;

            if(currGas < 0) {
                lowest_idx = i+1;
                currGas = 0;
            }
            
        }
        return currCost < 0 ? -1 : lowest_idx;
    }
}

public class P14_Gas_Station {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println("starting index: " + sol.canCompleteCircuit(gas, cost));
        sc.close();
    }
}