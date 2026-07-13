package Arrays.Easy;

import java.util.Scanner;

public class IsArraySortedOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        if (isArraySorted(array) == 1) {
            System.out.println("Array is Sorted in Ascending order");
        } else if (isArraySorted(array) == -1) {
            System.out.println("Array is Sorted in Descending order");
        } else {
            System.out.println("Array is not Sorted");
        }

        sc.close();
    }

    // TC : O(n) --> WC
    public static int isArraySorted(int[] nums) {

        boolean isAscSorted = true;
        boolean isDesSorted = true;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                isAscSorted = false;
            }

            if (nums[i] < nums[i + 1]) {
                isDesSorted = false;
            }
        }

        if (isAscSorted) {
            return 1;
        }

        if (isDesSorted) {
            return -1;
        }

        return 0;
    }
}
