package BinarySearch.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccur {
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
        int x = sc.nextInt();

        int[] bruteAns = brute(nums, x);
        System.out.println("Brute Force: " + Arrays.toString((bruteAns)));

        int[] betterAns = better(nums, x);
        System.out.println("Better: " + Arrays.toString((betterAns)));

        int[] optimalAns = optimal(nums, x);
        System.out.println("Optimal: " + Arrays.toString((optimalAns)));

        sc.close();
    }

    // TC: O(n)
    // SC: O(1)
    public static int[] brute(int[] nums, int x) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == x) {

                if (first == -1) {
                    first = i;
                }

                last = i;
            }
        }

        return new int[]{first, last};
    }

    // TC: O(n)
    // SC: O(1)
    public static int[] better(int[] nums, int x) {

        if (nums.length == 1 && x == nums[0]) {
            return new int[]{0, 0};
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == x) {

                int i = mid;
                int j = mid;

                // Right side mein x search karo
                while (j <= nums.length - 1 && nums[j] == x) {
                    j++;
                }

                // Left side mein x search karo
                while (i >= 0 && nums[i] == x) {
                    i--;
                }

                return new int[]{i + 1, j - 1};

            } else if (nums[mid] > x) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }


    // First and last occurrence means
    // Lower Bound and Upper Bound
    // TC: O(log n)
    // SC: O(1)
    public static int[] optimal(int[] nums, int x) {

        int left = 0;
        int right = nums.length - 1;

        int lowerB = -1;

        // First occurrence = Lower Bound
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == x) {

                lowerB = mid;

                // Aur left mein target ho sakta hai
                right = mid - 1;

            } else if (nums[mid] > x) {

                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }

        // Agar element present hi nahi hai
        if (lowerB == -1) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = nums.length - 1;

        int upperB = nums.length;

        // Last Occurrence = Upper Bound - 1
        while (low <= high) {

            int midd = low + (high - low) / 2;

            if (nums[midd] == x) {

                // Aur right mein target ho sakta hai
                low = midd + 1;

            } else if (nums[midd] > x) {

                upperB = midd;
                high = midd - 1;

            } else {

                low = midd + 1;
            }
        }

        return new int[]{lowerB, upperB - 1};
    }

}