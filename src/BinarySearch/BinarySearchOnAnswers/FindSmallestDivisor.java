package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindSmallestDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println("Smallest divisor: " + smallestDivisor(nums, threshold));

        sc.close();
    }


    // TC: O(N * log(max))
    // SC: O(1)
    public static int smallestDivisor(int[] nums, int threshold) {

        // Array me se maximum value nikal rahe hain kyuki maximum possible divisor max value ho sakta hai.
        // ye isliye nikal rhe hai taaki BS ka search space mil sake
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int left = 1;
        int right = max;
        int ans = max + 1;

        while (left <= right) {

            // Mid ko current divisor maan kar check karenge.
            int mid = left + (right - left) / 2;

            // Current divisor se divide karne ke baad total sum store karega.
            int temp = 0;

            for (int i = 0; i < nums.length; i++) {

                // Ceiling division use kar rahe hain.
                // (a + b - 1) / b se a / b ka ceil milta hai.
                temp += (nums[i] + mid - 1) / mid;
            }

            // Agar total sum threshold se kam ya equal hai toh current divisor possible answer hai.
            if (temp <= threshold) {

                // Current divisor ko answer maan lo.
                ans = mid;

                // Ab aur chhota divisor check karenge.
                right = mid - 1;

            } else {

                // Agar sum threshold se bada hai toh divisor increase karna padega.
                // Bada divisor hone par quotient aur total sum kam hoga.
                left = mid + 1;
            }
        }

        return ans;
    }
}