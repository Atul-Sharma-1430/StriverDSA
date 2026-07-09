package ImportantSortingTech.Sorting1;

import java.util.Arrays;
import java.util.Scanner;

//Bubble Sort and Selection Sort are opposite in terms of what gets fixed first:
//Bubble Sort:
//After each pass, the largest element of the unsorted part moves to its correct position at the end.

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int [] array = new int[size];

        System.out.print("Enter " + size + " numbers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        BSort(array);

        sc.close();
    }
    // Time Complexity:
    // Worst Case : O(n²)  -> Array is in reverse sorted order.
    // Average Case: O(n²)
    // Best Case  : O(n²)  -> Basic Bubble Sort (without optimization).

    // Best Case  : O(n)   -> Optimized Bubble Sort using a 'swapped' flag,
    //                        because no swaps occur if the array is already sorted.
    public static void BSort(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwapped = false;  // For Best Case
            for (int j = 0; j < nums.length - i - 1; j++) { // Bcz last me elements sorted hote chale jaate hain isliye ye condition
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }

            if(!isSwapped) break; // If Already Sorted then no swap will happen means loop runs one time only hence O(n)
        }

        System.out.println(Arrays.toString(nums));
    }
}
