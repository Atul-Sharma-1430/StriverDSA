package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

        System.out.println(better(array));
        System.out.println(optimal(array));

        input.close();
    }

    // TC : O(n) cz Hashset taken O(1) time
    // SC : O(n) Hashset
    public static int brute(int [] array) {
        Set<Integer> set = new HashSet<>();

        for (int j : array) {
            set.add(j);
        }

        return set.size();
    }

    // Pattern : Two Pointer
    // TC : O(n)
    // SC : O(1)
    public static int better(int [] array) {
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

    // Pattern : Two Pointer
    // TC : O(n)
    // SC : O(1)
    public static int optimal(int [] array) {
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
