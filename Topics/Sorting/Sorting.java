package Topics.Sorting;

import java.util.Arrays;

class Helper_Sorting {
    /*  
    
    Selection Sort
        TC:
        - Best: O(N^2)
        - Average: O(N^2)
        - Worst: O(N^2)
        SC: O(1)

        Actual run:
        0 : n-1
        1 : n-1
        2 : n-1
        3 : n-1
        ...
    
    */
    void selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            int mini = i;
            for(int j=i; j<n; j++) {
                if(nums[j] < nums[mini]) {
                    mini = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[mini];
            nums[mini] = temp;
        }
    }
    /*
    
    Bubble Sort
        TC: 
        - Best: O(N)
        - Average: O(N^2)
        - Worst: O(N^2)
        SC: O(1)
    */
    void bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<i; j++) {
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    void bubbleSort_BestCase(int[] nums) {
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            int flag = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = 1;
                }
            }
            if(flag == 0) break;
            System.out.println("runs");
        }
    }

    /*
    
    Insertion Sort
        TC:
        - Best : O(N)
        - Average : O(N^2)
        - Worst : O(N^2)
    
    */
    void insertionSort(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]) {
                int tmp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
    }

    /*
    
    Quick Sort
        TC:
        - Best: O(NlogN)
        - Average: O(NlogN)
        - Worst: O(N^2)
        SC: O(1)    
    */
    void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        qs(nums, low, high);
    }
    void qs(int[] nums, int low, int high) {
        if(low < high) {
            int pIndex = partition(nums, low, high);
            qs(nums, low, pIndex-1);
            qs(nums, pIndex+1, high);
        }
    }
    int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i < j) {
            while(nums[i] <= pivot && i <= high-1) {
                i++;
            }
            while(nums[j] > pivot && j >= low+1) {
                j--;
            }
            if(i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[low];
        nums[low] = nums[j];
        nums[j] = tmp;
        return j;
    }

    /*
    
    Merge Sort
        TC:
        - BEST,AVERAGE & WORST: O(NlogN)
        SC: O(N)

    */

    void mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        ms(nums, low, high);
    }

    void ms(int[] nums, int low, int high) {
        if(low == high) return;
        int mid = low + (high-low)/2;
        ms(nums, low, mid);
        ms(nums, mid+1, high);
        merge(nums, low, mid, high);
    }
    void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[nums.length];
        int j = 0;
        int l = low;
        int r = mid+1;
        while(l <= mid && r <= high) {
            if(nums[l] <= nums[r]) {
                temp[j++] = nums[l];
                l++;
            }
            else {
                temp[j++] = nums[r];
                r++;
            }
        }
        while(l <= mid) {
            temp[j++] = nums[l];
            l++;
        }

        while(r <= high) {
            temp[j++] = nums[r];
            r++;
        }

        for(int i=low; i<=high; i++) {
            nums[i] = temp[i-low];
        }
    }
}

public class Sorting {
    public static void main(String[] args) {
        Helper_Sorting hs = new Helper_Sorting();
        int[] nums = {13,46,24,52,20,9};
        /* Selection Sort */
        // System.out.println("Array before sorting: " + Arrays.toString(nums));
        // hs.selectionSort(nums);
        // System.out.println("Array after sorting (selection sort): " + Arrays.toString(nums));

        /* Bubble Sort */
        // System.out.println("Array before sorting: " + Arrays.toString(nums));
        // hs.bubbleSort(nums);
        // System.out.println("Array after sorting (bubble sort): " + Arrays.toString(nums));

        /* Bubble Sort for Best Case Scenario */
        // int[] nums2 = {1,2,3,4,5,6,7};
        // System.out.println("Array before sorting: " + Arrays.toString(nums2));
        // hs.bubbleSort_BestCase(nums2);
        // System.out.println("Array after sorting (bubble sort): " + Arrays.toString(nums2));

        /* Insertion Sort */
        // System.out.println("Array before sorting: " + Arrays.toString(nums));
        // hs.insertionSort(nums);
        // System.out.println("Array after sorting (insertion sort): " + Arrays.toString(nums));


        /* Quick Sort */
        // System.out.println("Array before sorting: " + Arrays.toString(nums));
        // hs.quickSort(nums);
        // System.out.println("Array after sorting (quick sort): " + Arrays.toString(nums));

        /* Merge Sort */
        System.out.println("Array before sorting: " + Arrays.toString(nums));
        hs.mergeSort(nums);
        System.out.println("Array after sorting (merge sort): " + Arrays.toString(nums));
    }
}
