package ImportantSortingTech.Sorting2;

import java.util.*;

public class MergeSorting {
    public static void MS(int[] nums, int st, int end) {
        if(st >= end) {    // When size will be 1 then st and end will point same value.
            return;
        }

        int mid = (st + end) / 2;

        MS(nums , st , mid);            // Left half of array
        MS(nums, mid+1, end);       // Right Half of array

        merge(nums , st , mid , end);
    }

    public static void merge(int[] array, int st, int mid, int last) {
        // left goes from [ low ... mid ]
        // right goes from [ mid+1 ... high ]

        int left = st, right = mid+1, i = 0;

        // Bcz everytime when this merge is called we don't need the temp array of entire size hence not using array.length
        // Temp array sorts only that much part for which the recursion call is made so if it is at the last step the array size will be 1 so there if we create tempArray of size array.length it would take more memory unnecessarily.
        int[] tempArray = new int[last - st + 1];

        while(left <= mid && right <= last) {
            if(array[left] <= array[right]) {
                tempArray[i] = array[left];
                left++;
            } else {
                tempArray[i] = array[right];
                right++;
            }
            i++;
        }

        // Remaining Part from left sorted array
        while (left <= mid) {
            tempArray[i++] = array[left++];
        }

        // Remaining Part from right sorted array
        while (right <= last) {
            tempArray[i++] = array[right++];
        }

        // Copying into original array
        for(int j = 0; j < i; j++) {
            array[st + j] = tempArray[j];
        }

        // This is getting printed again and again cz merge() getting called again and again is completely valid.
        // That is the core idea of Merge Sort. hence try to return the array and print in main function
        System.out.println("Sorted array is : " + Arrays.toString(array));
    }

    //    Time Complexity:
    //    Best:    O(n log n)
    //    Average: O(n log n)
    //    Worst:   O(n log n)
    //    O(n) for merging and O(log n) for recursion
    //
    //    Space Complexity:
    //    O(n) --> Extra temp array
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        MS(array , 0 , size-1);
        sc.close();
    }
}
