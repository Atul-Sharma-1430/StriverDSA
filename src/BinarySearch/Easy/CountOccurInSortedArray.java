package BinarySearch.Easy;

import java.util.Scanner;

public class CountOccurInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Brute Count: " + countBrute(nums, target));
        System.out.println("Optimal Count: " + countOptimal(nums, target));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int countBrute(int[] nums, int target) {

        int count = 0;

        for (int num : nums) {

            if (num == target) {
                count++;
            }
        }

        return count;
    }

    // TC : O(log n)
    // SC : O(1)
    public static int countOptimal(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int lowerB = -1;

        // Lower Bound
        while (left <= right) {
            int midL = left + (right - left) / 2;

            if (nums[midL] >= target) {
                lowerB = midL;
                right = midL - 1;
            } else {
                left = midL + 1;
            }
        }

        if (lowerB == -1) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        int upperB = nums.length;

        // Upper Bound
        while (low <= high) {
            int midU = low + (high - low) / 2;

            if (nums[midU] > target) {
                upperB = midU;
                high = midU - 1;
            } else {
                low = midU + 1;
            }
        }

        return upperB - lowerB; // bcz lower bound will point to the first occurence and right bound will point to first elem greater than target hence diff
    }
}