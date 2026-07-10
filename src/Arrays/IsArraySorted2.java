package Arrays;

import java.util.Scanner;

public class IsArraySorted2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        if (check(array) == 0) {
            System.out.println("Array is already Sorted");
        } else if(check(array) == 1) {
            System.out.println("Yes the Array is rotated and sorted");
        } else {
            System.out.println("Array is Rotated but not sorted");
        }

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int check(int[] nums) {

        // If the array is sorted and rotated then there will be only one point of breakdown where the increasing pattern will change. hence just count no. of brk points.
        int brkCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // Here Modular is done to check circular BreakDown
            // [2,1,3,4] ==> Here we will get only one point of break which is 1 and 3 but circularly 2 and 4 are also not in order hence not sorted
            if (nums[(i + 1) % nums.length] < nums[i]) {  // i+1 = 3+1 = 4 % 4 = 0 which is arr[0] = 2 < arr[3] = 4 hence count increases twice
                brkCount++;
            }
        }

        if (brkCount == 0) return 0;
        if (brkCount == 1) return 1;
        return -1;
    }
}
