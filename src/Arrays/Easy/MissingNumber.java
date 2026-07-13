package Arrays.Easy;

import java.util.Scanner;

public class MissingNumber {
    // TC : O(n)
    // SC : O(1)
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
    public static int findMissingNumberXor(int [] array) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < array.length; i++) {
            xor1 ^= array[i];  // Keep the xor of elem of array
            xor2 ^= (i+1); // Keep the xor of natural num from 1 to n
        }
        xor2 = xor2 ^ array.length + 1;

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int missing = findMissingNumberXor(array);

        System.out.println("Missing Number: " + missing);

        sc.close();
    }
}