package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayWithXorK {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target XOR: ");
        int target = sc.nextInt();

        System.out.println("Number of Subarrays with XOR " + target + " = " + findSubarray(nums, target));

        sc.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static int findSubarray(int[] nums, int target) {

        // Stores <Prefix XOR, Frequency>
        Map<Integer, Integer> map = new HashMap<>();

        // Empty Prefix XOR
        map.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // Update Prefix XOR
            prefixXor ^= nums[i];

            // Required Previous Prefix XOR
            int prev = prefixXor ^ target;

            // If found, add its frequency
            if (map.containsKey(prev)) {
                count += map.get(prev);
            }

            // Store Current Prefix XOR
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}