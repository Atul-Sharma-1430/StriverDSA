package Arrays;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
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

        System.out.println(rmvDuplicates1(array));
        System.out.println(rmvDuplicate2(array));

        input.close();
    }

    // Pattern : Two Pointer
    // TC : O(n)
    // SC : O(1)
    public static int rmvDuplicates1(int [] array) {
        int curr = 0;  // Points to the index of the last unique value
        int i = 1;  // Scans the array to find the next unique value
        int unique = 1;
        while(curr < array.length) {
            if (array[i] == array[curr]) {
                curr++;
            } else {
                i++;
                int temp = array[curr];
                array[curr] = array[i];
                array[i] = temp;
                curr++;
                unique++;
            }
        }

        return  unique;
    }

    public static int rmvDuplicate2(int [] array) {
        int curr = 0;  // Points to the index of the last unique value
        int next = 1;  // Scans the array to find the next unique value
        while(next < array.length) {
            if (array[curr] != array[next]) {
                curr++;
                array[curr] = array[next];
            }
            next++;
        }

        return ++curr;
    }
}
