package ImportantSortingTech.Sorting1;

import java.util.Arrays;
import java.util.Scanner;

// Takes an element and place it at correct place
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        IS(array);

        sc.close();
    }

    // 8 5 7 3 9
    // 3 5 7 8 9
    // Time Complexity:
    // Worst Case : O(n²)  -> Array is in reverse sorted order.
    // Average Case: O(n²)
    // Best Case  : O(n)   -> Array is already sorted, so the inner loop does almost no work.
    public static void IS(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
           int j = i;
           while(j > 0 && nums[j-1] > nums[j]) {  // if j >= 0  then j - 1 will be -1 that's why j > 0
                    int curr = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = curr;

                    j--;
           }
        }
        System.out.println(Arrays.toString(nums));
    }
}
