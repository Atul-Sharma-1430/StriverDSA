package BinarySearch.Easy;

import java.util.Scanner;

public class NumOfTimesArrayRotated {
    // Approach 1: Minimum value aur uska index track karna
    // TC : O(log n)
    // SC : O(1)
    public static int findKRotation1(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE; // Abhi tak ki minimum value store karenge
        int index = -1; // Minimum value ka index store karenge

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Agar mid ki value low se badi ya equal hai toh left half sorted hai
            if (nums[mid] >= nums[low]) {

                // Agar current sorted part ka first element minimum se chhota hai toh minimum update karo
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }

                // Left half sorted hai toh minimum right half me ho sakta hai
                low = mid + 1;

            } else {

                // Agar mid low se chhota hai toh minimum mid ya uske left side me ho sakta hai
                if (nums[mid] < min) {
                    min = nums[mid];
                    index = mid;
                }

                // Minimum left side me check karna hai
                high = mid - 1;
            }
        }

        // Minimum element ka index hi array ko rotate karne ki count hai
        return index;
    }

    // Approach 2: Mid ko right element se compare karna
    // TC : O(log n)
    // SC : O(1)
    public static int findKRotation2(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Agar mid right se bada hai toh minimum definitely mid ke right side me hoga
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Agar mid right se chhota ya equal hai toh mid bhi possible minimum hai, isliye mid ko include karte hain
            else {
                right = mid;
            }
        }

        // Jab left aur right same ho jayenge toh wahi minimum element ka index hoga
        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Approach 1: " + findKRotation1(nums));
        System.out.println("Approach 2: " + findKRotation2(nums));

        sc.close();
    }
}