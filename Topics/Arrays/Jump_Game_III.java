import java.util.*;

class Solution {
    // Your Solution class code here
    boolean canJump(int[] nums, int start) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int top = 0;
        int l = 0, r = 0;
        while(!q.isEmpty()) {
            top = q.poll();
            if(nums[top] == 0) return true;
            l = top - nums[top];
            r = top + nums[top];
            if(l >= 0 && l < n && visited[l] == false) {
                q.offer(l);
                visited[l] = true;
            } 

            if(r >= 0 && r < n && visited[r] == false) {
                q.offer(r);
                visited[r] = true;
            }
        }
        return false;
    }
}

public class Jump_Game_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Solution sol = new Solution();
        int[] nums = {4,2,3,0,3,1,2};
        int start = 0;
        System.out.println("Can jump?: " + sol.canJump(nums, start));
        sc.close();
    }
}