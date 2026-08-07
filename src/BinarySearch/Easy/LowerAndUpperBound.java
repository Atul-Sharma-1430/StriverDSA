package BinarySearch.Easy;

import java.util.Scanner;

public class LowerAndUpperBound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter " + size + " sorted array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int x = sc.nextInt();

        int lb = lowerBound(nums, x);
        int ub = upperBound(nums, x);

        System.out.println("Lower Bound Index: " + lb);
        System.out.println("Upper Bound Index: " + ub);

        sc.close();
    }

    // Pehla index return karega jahan nums[i] >= x ho.
    // Agar aisa koi element nahi mila to nums.length return hoga.
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int lowerBound(int[] nums, int x) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            // Integer overflow avoid karne ke liye
            int mid = left + (right - left) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                right = mid - 1; // Aur left side me check karo kya pta koi aur chhota mil jaaye
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Pehla index return karega jahan nums[i] > x ho.
    // Agar aisa koi element nahi mila to nums.length return hoga.
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int upperBound(int[] nums, int x) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            // Integer overflow avoid karne ke liye
            int mid = left + (right - left) / 2;

            if (nums[mid] > x) {
                ans = mid;
                right = mid - 1; // Aur left side me check karo kya pta koi aur chhota mil jaaye
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}