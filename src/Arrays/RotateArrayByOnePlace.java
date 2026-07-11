package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayByOnePlace {
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

        int[] leftArray = Arrays.copyOf(array, array.length);
        int[] rightArray = Arrays.copyOf(array, array.length);

        System.out.println("Left Rotate by one: " + rotateLeftByOne(leftArray));
        System.out.println("Right Rotate by one: " + rotateRightByOne(rightArray));

        input.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static String rotateLeftByOne(int [] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i-1] = array[i];
        }

        array[array.length-1] = temp;
        return Arrays.toString(array);
    }

    public static String rotateRightByOne(int [] array) {
        int temp = array[array.length-1];
        for (int i = array.length-1; i > 0; i--) {
            array[i] = array[i-1];
        }

        array[0] = temp;
        return Arrays.toString(array);
    }
}
