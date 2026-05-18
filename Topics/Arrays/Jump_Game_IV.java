import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        int curr = 0, left = 0, right = 0, size = 0, count = 0;
        while(!q.isEmpty()) {
            size = q.size();
            for(int i=0; i<size; i++) {
                curr = q.poll();
                if(curr == n-1) return count;
                left = curr - 1;
                right = curr + 1;
                if(left >= 0 && left < n && !visited[left]) {
                    visited[left] = true;
                    q.offer(left);
                }
                if(right >= 0 && right < n && !visited[right]) {
                    visited[right] = true;
                    q.offer(right);
                }
                List<Integer> nbrs = map.get(arr[curr]);
                if(nbrs != null) {
                    for(int nbr : nbrs) {
                        if(curr != nbr && !visited[nbr]) {
                            q.offer(nbr);
                            visited[nbr] = true;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            count++;
        }
        return -1;
    }
}

public class Jump_Game_IV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] nums = {100,-23,-23,404,100,23,23,23,3,404}; // Expected: 3
        System.out.println("Minimum jumps to reach last index with given conditions: " + sol.minJumps(nums));
        sc.close();
    }
}