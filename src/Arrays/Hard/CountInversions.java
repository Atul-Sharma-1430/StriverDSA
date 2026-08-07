package Arrays.Hard;

// Given an array arr[] of N integers, find the number of inversions in the array.
// An inversion is a pair of indices (i, j) such that:
// 0 ≤ i < j < N
// arr[i] > arr[j]

import java.util.Scanner;

public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Answer: " + brute(nums));

        // Merge Sort array ko modify karta hai, isliye copy
        int[] copy = nums.clone();

        optimalAns = 0; // Reset global variable
        System.out.println("Optimal Answer: " + optimal(copy));

        sc.close();
    }

    public static int brute(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Merges two sorted halves of the array
    // Also counts inversions while merging
    public static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            // Left element is smaller, so no inversion
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                // Right element is smaller than left element
                // Since left half is sorted, all remaining elements
                // from 'left' to 'mid' are also greater than arr[right]
                // Number of inversions = mid - left + 1
                optimalAns += mid - left + 1;

                temp[k++] = arr[right++];
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy merged array back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }


    public static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    static long optimalAns = 0;

    // Uses Merge Sort to count inversions
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static long optimal(int[] nums) {
        optimalAns = 0;
        mergeSort(nums, 0, nums.length - 1);
        return optimalAns;
    }
}
