package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZerosToEnd {
    public static int[] moveZeros(int [] array) {
        int numTracker = 0;
        int zeroTracker = 0;

        while(zeroTracker < array.length) {
            if (array[zeroTracker] != 0) {
                int temp = array[zeroTracker];
                array[zeroTracker] = array[numTracker];
                array[numTracker] = temp;
                numTracker++;
            }
            zeroTracker ++;
        }

        return array;
    }

    public static int[] moveZeros2(int[] array) {
        int insertPos = 0;

        for (int num : array) {
            if (num != 0) {
                array[insertPos++] = num;
            }
        }

        while (insertPos < array.length) {
            array[insertPos++] = 0;
        }

        return array;
    }

    // TC = O(n)
    // SC = O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Array after moving all zeros to end " + Arrays.toString(moveZeros(array)));
        System.out.println("Array after moving all zeros to end " + Arrays.toString(moveZeros2(array)));
        sc.close();
    }
}
