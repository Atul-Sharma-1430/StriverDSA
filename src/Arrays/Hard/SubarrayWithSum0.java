package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayWithSum0 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Number of Subarrays with Sum 0 " + findSubarray(nums));

        sc.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static int findSubarray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Empty Prefix Sum
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // Update Prefix Sum
            prefixSum += nums[i];

            // If same prefix sum appeared before,
            // all those occurrences form sum = 0 subarrays
            count += map.getOrDefault(prefixSum, 0);

            // Store current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}