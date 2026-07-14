package Arrays.Easy;

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
}
