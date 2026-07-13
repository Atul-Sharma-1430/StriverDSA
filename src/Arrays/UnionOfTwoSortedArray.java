package Arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the 1st array:");
        int size1 = sc.nextInt();

        int[] array1 = new int[size1];

        System.out.print("Enter the size of th 2nd array:");
        int size2 = sc.nextInt();

        int[] array2 = new int[size2];

        System.out.println("Enter " + size1 + " Elements of first array: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = sc.nextInt();
        }

        System.out.println("Enter " + size2 + " Elements of Second array: ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = sc.nextInt();
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        ArrayList<Integer> myArray = union(array1, array2);
        System.out.println(myArray);

        sc.close();

    }

    // Time Complexity: O(n + m)
    // Space Complexity (including output): O(n + m)
    public static ArrayList<Integer> union(int[] array1, int[] array2) {
        ArrayList<Integer> ansArray = new ArrayList<>();

        int left = 0, right = 0;
        int last = -1; // To Check Whether the element is already taken or not.

        while (left < array1.length && right < array2.length) {
            if (array1[left] <= array2[right]) {
                if (array1[left] != last) {
                    ansArray.add(array1[left]);
                    last = array1[left];
                }
                left++;
            } else {
                if (array2[right] != last) {
                    ansArray.add(array2[right]);
                    last = array2[right];
                }
                right++;
            }
        }

        while (left < array1.length) {
            if (array1[left] != last) {
                ansArray.add(array1[left]);
                last = array1[left];
            }
            left++;
        }

        while (right < array2.length) {
            if (array2[right] != last) {
                ansArray.add(array2[right]);
                last = array2[right];
            }
            right++;
        }

        return ansArray;
    }
}
