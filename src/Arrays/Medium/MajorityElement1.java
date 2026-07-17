package Arrays.Medium;

import java.util.*;

public class MajorityElement1 {

    // Solution 1: Using Sorting
    // TC : O(n log n)
    // SC : O(1)
    public static int majorityElementUsingSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    // Solution 2: Using Boyer-Moore Voting Algorithm
    // TC : O(n)
    // SC v: O(1)
    public static int majorityElementUsingVoting(int[] nums) {
        int elem = 0; // tracks the majority element
        int count = 0;

        int i = 0;
        while (i < nums.length) {
            // if count becomes zero anyway means previously no element was majority element therefore pick new element
            if (count == 0) {
                elem = nums[i];
            }

            // if num is same then increase counter else decrease counter
            if (nums[i] != elem) {
                count--;
            } else {
                count++;
            }

            i++;
        }

        // at last elem will contain the majority element
        return elem;
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int ans1 = majorityElementUsingSorting(nums.clone());
        int ans2 = majorityElementUsingVoting(nums);

        System.out.println("Majority Element using Sorting: " + ans1);
        System.out.println("Majority Element using Voting: " + ans2);
    }
}
