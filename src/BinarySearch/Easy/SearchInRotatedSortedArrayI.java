package BinarySearch.Easy;

import java.util.Scanner;

public class SearchInRotatedSortedArrayI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Brute Answer: " + searchBrute(nums, target));
        System.out.println("Optimal Answer: " + searchOptimal(nums, target));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int searchBrute(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // TC : O(log n)
    // SC : O(1)
    public static int searchOptimal(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted hai
            else if (nums[mid] >= nums[left]) {
                // toh pahle check kro ki kya target left side me hai ki nhi agar left side me rhega toh usi side me check kro
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } // warna right side me hoga
                else {
                    left = mid + 1;
                }
            }

            // Right half sorted hai
            else {
                // toh pahle check kro ki kya target right side me hai ki nhi agar right side me rhega toh usi side me check kro
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } // warna left side check kro
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}