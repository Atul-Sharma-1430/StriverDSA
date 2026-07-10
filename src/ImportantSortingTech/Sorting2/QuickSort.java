package ImportantSortingTech.Sorting2;

import java.util.*;

public class QuickSort {
    public static void QS(int [] array, int low, int high) {
        if (low < high) {
            int breakingIndex = findPivotIndex(array, low, high);

            QS(array, low, breakingIndex-1);
            QS(array, breakingIndex +1, high);
        }
    }

    public static int findPivotIndex(int [] array, int low, int high) {
        int pivot = array[low]; // Pivot element

        int i = low, j = high;

        while(i < j) {
            // Move i until an element greater than the pivot is found.
            while(array[i] <= pivot && i <= high-1) {
                i++;
            }
            // Move j until an element less than or equal to the pivot is found.
            while(array[j] > pivot && j >= low+1) {
                j--;
            }

            // if we got any value from above loops then swap them so that lesser value than pivot goes to left and greater value then pivot goes to right
            if(i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // At Last when i > j then all elements which are smaller will be on left side and greater will be on right side, at that time swap the array[j] value with pivot which will be its correct place
        // When i >= j place the pivot at correct position by swapping it with array[j]
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        // Index of Pivot element
        return j;
    }

    // Time Complexity:
    // Best/Average : O(n log n)
    // Worst        : O(n²)

    // Space Complexity:
    // Best/Average : O(log n)
    // Worst        : O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        QS(array, 0 , array.length-1);
        System.out.println(Arrays.toString(array));
        sc.close();
    }
}
