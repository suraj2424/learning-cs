import java.util.*;

class Next_Greater_Solution {
    int[] findNextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int curr = 0;
        for(int i=0; i<n; i++) {
            curr = nums[i];
            for(int j=i+1; j<n; j++) {
                if(nums[j] > curr) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    int[] findNextGreater_1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()]) {
                index = st.pop();
                ans[index] = nums[i];
            }
            st.push(i);
        }
        return ans;
    }

    int[] findNextGreater_2(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0; i<2*n; i++) {
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                ans[st.pop()] = nums[i % n];
            }
            if(i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}

public class Question_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        Next_Greater_Solution ngs = new Next_Greater_Solution();
        int[] nums = {5,1,2,4,3};
        int[] ans = ngs.findNextGreater_1(nums);
        System.out.println(Arrays.toString(ans));
        sc.close();
    }
}