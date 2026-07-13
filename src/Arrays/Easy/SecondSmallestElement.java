package Arrays.Easy;

import java.util.Scanner;

public class SecondSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Second Smallest element is: " + secSmallest(array));

        sc.close();
    }

    public static int secSmallest(int [] array) {
        int smallest = array[0];
        int sSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                sSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < sSmallest && array[i] != smallest) {
                sSmallest = array[i];
            }
        }

        if (sSmallest == Integer.MAX_VALUE) {
            return -1;
        }

        return sSmallest;
    }
}
