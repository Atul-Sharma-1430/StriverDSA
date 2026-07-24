package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionsAndArraysDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(10);
        list.add(20);

        ArrayList<Integer> src = new ArrayList<>();
        src.add(1);
        src.add(2);
        src.add(3);

        ArrayList<Integer> dest = new ArrayList<>();
        dest.add(0);
        dest.add(0);
        dest.add(0);

        int[] arr = { 5, 2, 8, 1, 4 };
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        int[][] arr2D = { { 1, 2 }, { 3, 4 } };

        // ================= Collections =================

        // TC: O(n log n) - Sorts the list in ascending order
        Collections.sort(list);

        // TC: O(n) - Reverses the list
        Collections.reverse(list);

        // TC: O(n) - Randomly shuffles the list
        Collections.shuffle(list);

        // TC: O(1) - Swaps elements at the given indexes
        Collections.swap(list, 0, 1);

        // TC: O(n) - Returns the maximum element
        Collections.max(list);

        // TC: O(n) - Returns the minimum element
        Collections.min(list);

        // TC: O(log n) - Searches an element (List must be sorted)
        Collections.binarySearch(list, 10);

        // TC: O(n) - Counts occurrences of an element
        Collections.frequency(list, 10);

        // TC: O(n) - Replaces every element with the given value
        Collections.fill(list, 5);

        // TC: O(n) - Copies src into dest (dest size >= src size)
        Collections.copy(dest, src);

        // TC: O(1) - Returns comparator for descending order
        Collections.reverseOrder();

        // ================= Arrays =================

        // TC: O(n log n) - Sorts the array
        Arrays.sort(arr);

        // TC: O(n log n) - Parallel sort (better for large arrays)
        Arrays.parallelSort(arr);

        // TC: O(log n) - Searches an element (Array must be sorted)
        Arrays.binarySearch(arr, 5);

        // TC: O(n) - Fills the array with the given value
        Arrays.fill(arr, 10);

        // TC: O(n) - Returns a new array of given length
        Arrays.copyOf(arr, 5);

        // TC: O(k) - Copies elements from index 1 to 3
        Arrays.copyOfRange(arr, 1, 4);

        // TC: O(n) - Checks if two arrays are equal
        Arrays.equals(a, b);

        // TC: O(n) - Converts array to String
        Arrays.toString(arr);

        // TC: O(n) - Converts multidimensional array to String
        Arrays.deepToString(arr2D);

        // TC: O(1) - Returns a fixed-size List backed by the array
        Arrays.asList(1, 2, 3);
    }
}