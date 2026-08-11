package BinarySearch.Easy;

import java.util.Scanner;

public class FindPeakElement {
    // TC: O(n), SC: O(1)
    public static int findPeakElement1(int[] nums) {
        // Agar array mein sirf ek element hai toh wahi peak element hoga.
        if (nums.length == 1) {
            return 0;
        }

        // First element ko check kar rahe hain kyuki uska sirf right neighbour hota hai.
        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            // Agar current element dono neighbours se bada hai toh wahi peak element hai.
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // Agar beech mein peak nahi mili toh last element peak hoga.
        return nums.length - 1;
    }

    // TC: O(log n), SC: O(1)
    public static int findPeakElement2(int[] nums) {

        // Agar array mein sirf ek element hai toh wahi peak element hoga.
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Agar mid ke right wala element bada hai toh peak definitely right side mein milegi.
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            }

            // Agar mid right ki taraf grow nahi kar raha toh peak mid ya left side mein hogi.
            else {
                right = mid;
            }
        }

        // Jab left aur right same ho jayenge toh wahi kisi peak element ka index hoga.
        return left;
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

        System.out.println("Peak Element Index using Linear Search: " + findPeakElement1(nums));
        System.out.println("Peak Element Index using Binary Search: " + findPeakElement2(nums));

        sc.close();
    }
}