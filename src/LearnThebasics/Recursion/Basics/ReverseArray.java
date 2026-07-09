package LearnThebasics.Recursion.Basics;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        ReverseArray rev = new ReverseArray();
        rev.reverse(array, size);

        System.out.println("Reversed array: " + Arrays.toString(array));

        sc.close();
    }

    public void reverse(int[] arr, int n) {

        if (n <= arr.length / 2) return;

        int start = arr.length - n;
        int end = n - 1;

        // Swap
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, n - 1);
    }
}