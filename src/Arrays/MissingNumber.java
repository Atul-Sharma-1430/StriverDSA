package Arrays;

import java.util.Scanner;

public class MissingNumber {
    public static int findMissingNumber(int[] array) {
        int total = 0;

        for (int j : array) {
            total += j;
        }

        int n = array.length;
        int sum = (n * (n + 1)) / 2;

        return sum - total;
    }

    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int missing = findMissingNumber(array);

        System.out.println("Missing Number: " + missing);

        sc.close();
    }
}