import java.util.*;

class Standard{
    int binarySearch(int[] nums, int target) {
        int s = 0;
        int e = nums.length;
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                s = mid+1;
            }
            else {
                e = mid-1;
            }
        }
        if(s < nums.length && nums[s] == target) {
            return s;
        }
        return-1;
    }
}

class LowerBound { // First Occurence
    public int firstOccurence(int[] nums, int target) {
        int s = 0;
        int e = nums.length;
        while (s < e) {
            int mid = (s+e)/2;
            if(nums[mid] < target) {
                s = mid+1;
            }
            else {
                e = mid;
            }
        }
        if(s < nums.length && nums[s] == target) {
            return s;
        }
        return -1;
    }
}

class UpperBound{
    public int lastOccurence(int[] nums, int target) {
        int s = 0;
        int e = nums.length;
        while(s < e) {
            int mid = (s+e)/2;
            if(nums[mid] <= target) { // target or numbers smaller than target
                s = mid+1;
            }
            else {
                e = mid; // this element is too big
            }
        }
        // s is greater than target so we will check if (element at s-1) == target
        if(s >= 0 && nums[s-1] == target) {
            return s-1;
        }
        return -1;
    }
}

class FirstGreaterThanTarget{
    public int nextGreater(int[] nums, int target) {
        int s = 0;
        int e = nums.length;
        while (s < e) {
            int mid = (s+e)/2;
            if(nums[mid] <= target) {
                s = mid+1;
            }
            else {
                e = mid;
            }
        }
        return s;
    }
}

class FirstGreaterThanOrEqualTarget {
    int nextGreaterEqual(int[] nums, int target) {
        int s = 0;
        int e = nums.length;
        while(s < e) {
            int mid = (s+e)/2;
            if(nums[mid] < target) {
                s = mid+1;
            }
            else {
                e = mid;
            }
        }
        return s;
    }
}

class AnswerOnSearchSpace{
    public int binarySearchOnAnswer(int minAnswer, int maxAnswer) {
    int left = minAnswer;
    int right = maxAnswer;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (isFeasible(mid)) {
            right = mid;  // This works, but maybe we can do better
        } else {
            left = mid + 1;  // This does not work, need a larger value
        }
    }

    return left;  // Minimum feasible answer
}

    private boolean isFeasible(int candidate) {
        // Check if 'candidate' is a valid answer
        // This is problem-specific
        boolean flag = true;
        return flag;
    }
}

public class Binary_Search {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int target = 9;
        Standard std = new Standard();
        int ansIndex = std.binarySearch(nums, target);
        // System.out.println(ansIndex);

        


        // lower bound when duplicates exist
        int[] nums1 = {1, 3, 5, 7, 9, 9, 9, 11, 13};
        int target1 = 9;
        LowerBound lb = new LowerBound();
        int ansIndex1 = lb.firstOccurence(nums1, target1);
        // System.out.println(ansIndex1);
        
        



        // upper bound when duplicates exist
        int[] nums2 = {1, 3, 5, 7, 9, 9, 9, 11, 13};
        int target2 = 9;
        UpperBound up = new UpperBound();
        int ansIndex2 = up.lastOccurence(nums2, target2);
        // System.out.println(ansIndex2);





        // first element greater than target
        int[] nums3 = {1, 3, 5, 7, 9, 9, 9, 11, 13};
        int target3 = 9;
        FirstGreaterThanTarget fgtt = new FirstGreaterThanTarget();
        int ansIndex3 = fgtt.nextGreater(nums3, target3);
        System.out.println(ansIndex3);



    }    
}
