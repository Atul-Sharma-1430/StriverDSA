package BinarySearch.Easy;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
    // TC: O(log n), SC: O(1)
    public static int findMin1(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Agar mid right se bada hai toh minimum definitely mid ke right side mein hoga.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Warna minimum mid ya uske left side mein ho sakta hai, isliye mid ko eliminate nahi karenge.
            else {
                right = mid;
            }
        }

        // Jab left aur right same ho jayenge toh wahi minimum element ka index hoga.
        return nums[left];
    }

    // TC: O(log n), SC: O(1)
    public static int findMin2(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Agar mid left se bada ya equal hai toh left se mid tak ka part sorted hai.
            if (nums[mid] >= nums[left]) {

                // Sorted left part ka first element hi us part ka minimum hoga, use current min se compare kar rahe hain.
                if (nums[left] < min) {
                    min = nums[left];
                }

                // Left sorted part ka minimum mil gaya hai, isliye ab right side mein smaller minimum search karenge.
                left = mid + 1;
            }

            // Agar mid left se chhota hai toh minimum mid ya uske left side mein ho sakta hai.
            else {

                // Mid ko current minimum ke saath compare karke smaller value store kar rahe hain.
                if (nums[mid] < min) {
                    min = nums[mid];
                }

                // Mid ko minimum ke liye consider kar liya hai, isliye ab left side mein search karenge.
                right = mid - 1;
            }
        }

        // Final minimum value return kar rahe hain.
        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Minimum using Solution 1: " + findMin1(nums));
        System.out.println("Minimum using Solution 2: " + findMin2(nums));

        sc.close();
    }
}