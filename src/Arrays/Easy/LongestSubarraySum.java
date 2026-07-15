package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter " + size + " elements :");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target Sum: ");
        int target = sc.nextInt();

        System.out.println(brute(nums, target));
    }

    // Approach : Generate all Subarrays
    // Works in case of negatives
    // TC : O(n2) --> avg
    //      O(n3) --> worst
    // SC : O(1)
    public static int brute(int[] array, int target) {
        int maxLen = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {

                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }

                if (sum == target) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // Approach : Generate all Subarrays
    // Works in case of negatives
    // Calculate sum using previous value
    // TC : O(n2)
    // SC : O(1)
    public static int betterBrute(int[] array, int target) {
        int maxLen = 0;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];

                if (sum == target) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

        }

        return maxLen;
    }

    // TC : O(n)
    // SC : O(n)
    // Works for negatives as well
    // This is Optimal for array Containing negatives
    public static int better(int[] array, int target) {
        int maxLen = 0;
        long prefixSum = 0;// Carries the total sum till current index

        // Map to Store the total sum at each index
        HashMap<Long, Integer> myHashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];

            // we get sum == target means we got a subarray then update length accordingly
            if (prefixSum == target) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // prev to store the value which is the difference of current sum and target
            long prev = prefixSum - target;

            // If map has that prev value then we find the length of current subarray from that point to current index and then adjust length accordingly
            if (myHashMap.containsKey(prev)) {
                int tempLen = i - myHashMap.get(prev);
                maxLen = Math.max(maxLen, tempLen);
            }

            // Store only the first occurrence of the prefix sum.
            // Example: array = [2, 0, 0, 3], target = 3
            // Prefix sum 2 appears at indices 0, 1, and 2.
            // Keep index 0 because it gives the longest subarray [0, 0, 3] (length 3).
            // Hence we will just track its first occurance only where we get the prev
            // It basically Handles zero
            if (!myHashMap.containsKey(prefixSum)) {
                myHashMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
