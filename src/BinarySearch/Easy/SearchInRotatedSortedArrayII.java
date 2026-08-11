package BinarySearch.Easy;

import java.util.Scanner;

public class SearchInRotatedSortedArrayII {

    // TC: O(n), SC: O(1)
    public static boolean search1(int[] nums, int target) {

        // Har element ko check karenge ki target present hai ya nahi.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }

        // Agar poore array mein target nahi mila toh false return karenge.
        return false;
    }

    // Binary Search approach
    // TC: O(log n) average, O(n) worst case due to duplicates
    // SC: O(1)
    public static boolean search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Agar target mid, left ya right par mil gaya toh directly true return karenge.
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }

            // Agar left aur right equal hain toh duplicates ki wajah se sorted half identify nahi kar paayenge, isliye boundaries remove kar rahe hain.
            else if (nums[left] == nums[right]) {
                left++;
                right--;
            }

            // Agar mid ki value left se badi ya equal hai toh left half sorted hai.
            else if (nums[mid] >= nums[left]) {

                // Agar target sorted left half ke range mein hai toh right ko mid se pehle le aayenge.
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                // Warna target right half mein hoga isliye left ko mid ke baad le jayenge.
                else {
                    left = mid + 1;
                }
            }

            // Agar left half sorted nahi hai toh right half sorted hoga.
            else {

                // Agar target sorted right half ke range mein hai toh left ko mid ke baad le jayenge.
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                // Warna target left half mein hoga isliye right ko mid se pehle le aayenge.
                else {
                    right = mid - 1;
                }
            }
        }

        // Agar poori search ke baad target nahi mila toh false return karenge.
        return false;
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Brute Force Result: " + search1(nums, target));
        System.out.println("Binary Search Result: " + search2(nums, target));

        sc.close();
    }
}