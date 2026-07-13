package Arrays.Easy;

import java.util.Scanner;

public class LargestElement {
    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        if (size == 0) {
            System.out.println("Size cannot be Zero");
            input.close();
            return;
        }

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        int largest = Integer.MIN_VALUE;

        for (int j : array) {
            if (j > largest) {
                largest = j;
            }
        }

        System.out.println("The largest number in the element is: " + largest);

        input.close();
    }
}