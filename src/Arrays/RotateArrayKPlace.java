package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayKPlace {
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int [] rotateRightByKPlaces(int[] array, int k) {
        k = k % array.length; // First make it smaller than length of array
        k = (array.length - k) % array.length; // Then point the value of k from right side so that k will be equal to n-k so that it rotates the values from end side of array
                                               // Convert k to (n - k) because rotating right by k places
                                               // is the same as rotating left by (n - k) places.
        reverse(array, 0, k-1);
        reverse(array, k, array.length-1);
        reverse(array, 0, array.length-1);
        return array;
    }

    public static int [] rotateLeftByKPlaces(int[] array, int k) {
        k = k % array.length;

        reverse(array, 0, k-1);
        reverse(array, k, array.length-1);
        reverse(array, 0, array.length-1);
        return array;
    }

    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Rotated Array: " + Arrays.toString(rotateLeftByKPlaces(array, k)));
        System.out.println("Rotated Array: " + Arrays.toString(rotateRightByKPlaces(array, k)));

        sc.close();
    }
}