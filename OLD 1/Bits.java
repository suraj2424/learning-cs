// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*

'45' - 101101

*/

import java.util.Arrays;

class BitSet1 {

    /*
    
    SET 1

    Operation 1: Check K-th bit of number
            2: Set K-th Bit
            3. Clear K-th Bit
            4. Toggle K-th Bit
            5. Print Set Bits of a number    

    */


    boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
    int setKthBit(int n, int k) {
        int res = n | (1<<k);
        return res;
    }
    int clearKthBit(int n, int k) {
        int res = n & ~(1<<k);
        return res;
    }
    int toggleKthBit(int n, int k) {
        int res = n ^ (1<<k);
        return res;
    }
    void printBits(int n) {
        for(int i=4; i>=0; i--) {
            if((n & (1<<i)) != 0) {
                System.out.print("1"+"");
            }
            else {
                System.out.print("0"+"");
            }
        }
    }
}

class BitSet2{
    /*
    
    SET 2

        1. Hamming Weight [Leetcode 191 (EASY)]
        
        Given a positive integer n, write a function that returns the number of set bits 
        in its binary representation (also known as the Hamming weight).
    
        Approach 1:
        (For Loop till 32 bits) Condition checking ((n & (1<<i)) != 0)

        Approach 2
        (While Loop) Reducing 'n' self
            while(n != 0) 
                count++;
                n &= (n-1)

        

        
        2. Check if n is power of 2

        Given an integer n, return true if it is a power of two. Otherwise, return false.
        An integer n is a power of two, if there exists an integer x such that n == 2^x.

        3. Find Rightmost set bit

        Use: [ n & (-n) ]


        4. Turn Off Rightmost Set Bit

        Use: [ n & (n-1) ]

    
    */

    // Approach 1
    int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++) {
            if((n & (1<<i)) != 0) {
                count++;
            }
        }
        return count;
    }

    // Hint given  checking [n &= (n-1)]
    int hammingWeight2(int n) {
        int count=0;
        while(n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }



    // Power of 2
    boolean checkPowerOf_Two(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }


    // Find rightmost set bit
    int findRSB(int n) {
        int ans = n & (-n);
        return ans;
    }

    // Turn off Rightmost set Bit

    int turnOffRSB(int n) {
        int ans = n & (n-1);
        return ans;
    }



}

class BitSet3{
    /*
    
    SET 3

    1. Find element appearing once others twice [ Leetcode: 540. Single Element in Sorted Array ]

        Use: XOR repeatedly to cancel out twice one and once freq element will be remaining
        
        Description:

        You are given a sorted array consisting of only integers 
        where every element appears exactly twice, except for one element which appears exactly once.
        Return the single element that appears only once.
        Your solution must run in O(log n) time and O(1) space.

        --TWO APPROACHES--
        i. Linear search (finding xor across array of elements)
        ii. Binary Search (If array is sorted)

    2. Two numbers appearing once (others twice) [LEETCODE: 260. Single Number III]

        Description: 
        
        Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
        Find the two elements that appear only once. You can return the answer in any order.
        You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
    
    3. Missing number 0-n

        Description:

        Given an array nums containing n distinct numbers in the range [0, n], 
        return the only number in the range that is missing from the array.


    4. Counting Bits

        Description: 

        Given an integer n, return an array ans of length n + 1 
        such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

    
    */



    // Find once unique element others occurs twice
    int findOnce(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    // 540. Single element in sorted array
    int findOnceSorted(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r) {
            int mid = (l+r)/2;
            if((mid%2==0 && nums[mid] == nums[mid+1]) || (mid%2==1 && nums[mid] == nums[mid-1])) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }

    // LEETCODE: SINGLE NUMBER III
    // Find two elements with freq 1 while others have freq of 2
    int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        int k=0;
        while(((xor>>k) & 1) == 0) {
            k++;
        }
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(((num >> 1) & 1) == 0) {
                ans[0] ^= num;
            }
            else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    // LEETCODE: MISSING NUMBER
    int findMissing(int[] nums) {
        int n = nums.length;
        int sum = (n * (n+1))/2;
        int mSum = 0;
        for(int i=0; i<n; i++) {
            mSum += nums[i];
        }
        return sum - mSum;
    }

    // Approach 2 : USING XOR Operation
    int findMissing2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans ^= (nums[i] ^ i);
        }
        return ans ^ n;
    }

    // Approach 1 : Brute
    int totalSetBits(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

    int[] countingBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=1; i<n+1; i++) {
            ans[i] = totalSetBits(i);
        }
        return ans;
    }

    // Approach 2 : Using inbuilt method
    int[] countingBits2(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<n+1; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    // Approach 3
    int[] countingBits3(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=1; i<n+1; i++) {
            ans[i] = ans[i>>1] + (i & 1);
        }
        return ans;
    }

    // Approach 4
    int[] countingBits4(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=0; i<n+1; i++) {
            if(i % 2 == 0) {
                ans[i] = ans[i/2];
            }
            else {
                ans[i] = ans[i/2] + 1;
            }
        }
        return ans;
    }


}




public class Bits {
    public static void main(String[] args) {
        
        /* SET 1 */

        // BitSet1 set1 = new BitSet1();
        // int n = 45;
        // set1.printSetBits(n);





        /* SET 2 */

        // BitSet2 set2 = new BitSet2();
        // int n = 11;


        /*  Hamming Weight */
        // System.out.println("Number of bits of " + n + ": " + set2.hammingWeight2(n));


        /* Power of 2 */
        // System.out.println("Given number " + n + " is a power of 2: " + set2.checkPowerOf_Two(n));


        /* Rightmost set bit */
        // Here n = 11
        // Binary: 1011
        // Hence RSB = 1011
        // System.out.println("Right set bit of " + n + " : " + set2.findRSB(n));


        /* Turn off RSB */
        // System.out.println("Number after turning off Right most bit:" + n + " : " + set2.turnOffRSB(n));








        // BitSet3 set3 = new BitSet3();

        /* Find element appearing once while others elements appear twice */
        // int[] nums = {1,2,4,1,4,2,3};
        // System.out.println("Ans is: " + set3.findOnce(nums));



        /* LEETCODE: 540. Single Element in a Sorted Array */
        // int[] arr = {1,1,2,3,3,4,4,8,8};
        // System.out.println("Answer is: " + set3.findOnceSorted(arr));


        /* LEETCODE: 260. Single Number III */
        // int[] nums = {1,2,1,3,2,5};
        // int[] ans = set3.singleNumber(nums);
        // System.out.println("Answer is: " + Arrays.toString(ans));


        /* LEETCODE: 268. Missing Number */
        // int[] nums = {3,0,1};
        // Brute Approach
        // System.out.println("missing number: " + set3.findMissing(nums));

        // Optimal Approach
        // System.out.println("Missing number: " + set3.findMissing2(nums));


        /* LEETCODE: 338. Counting Bits */
        // int n = 7;
        // int[] ans = set3.countingBits4(n);
        // System.out.println(Arrays.toString(ans));


        





    }
}