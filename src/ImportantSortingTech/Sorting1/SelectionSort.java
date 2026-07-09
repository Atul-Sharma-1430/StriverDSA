package ImportantSortingTech.Sorting1;

import java.util.Arrays;
import java.util.Scanner;

// In Selection sort hum st se ek element chhose krte hain and then remaining part me jo smallest element hai usey dhundte hain then dono ko swap kr dete hain.
// fir same step hum next index ke liye krte hain cz uske pahle wale index ki value apne jagah pe sahi ho chuki hogi
// isme ek elememnt fixed lete hai usse compare krte hain poora array this is diff between selection and bubble sort
// After each pass, the smallest element of the unsorted part moves to its correct position at the start.
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int [] nums = new int[size];

        System.out.print("Enter " + size + " numbers:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        SS(nums);

        sc.close();
    }

    // Time Complexity:
    // Worst Case : O(n²)
    // Average Case: O(n²)
    // Best Case  : O(n²)
    // My Solution
    public static void SS(int [] nums) {
        // 8 7 9 2 4 5
        int i = 0;
        while(i < nums.length) {
            int smallest = nums[i++];

            for (int k = i-1; k < nums.length ; k++) {
                if(nums[k] < smallest) smallest = nums[k];
            }
            int curr = i-1;

            for (int j = i-1; j < nums.length; j++) {
                if (nums[j] == smallest) {
                    int temp = nums[curr];
                    nums[curr] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    // Optimised Solution
    public static void SS2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {

            int smallestIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }
}
