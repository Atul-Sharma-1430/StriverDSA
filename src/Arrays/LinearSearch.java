package Arrays;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int index = search(array, target);

        if (index == -1) {
            System.out.println(target + " is not present in the array");
        } else {
            System.out.println(target + " is present at index " + index);
        }

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int search(int [] array, int target) {

        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                index = i;
            }
        }

        return index;
    }
}
