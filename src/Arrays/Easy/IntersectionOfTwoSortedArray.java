package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoSortedArray {
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

        Arrays.sort(array1); // O(n log n)
        Arrays.sort(array2); // // O(m log m)

        ArrayList<Integer> myArray = intersection(array1, array2);
        System.out.println(myArray);

        sc.close();
    }

    // TC : O(n log n + m log m + n + m) ==> O(n log n + m log m)
    // SC : O(k)
    public static ArrayList<Integer> intersection(int[] array1, int[] array2) {
        ArrayList<Integer> ansArray = new ArrayList<>();

        int left = 0;
        int right = 0;
        int last = -1;

        while (left < array1.length && right < array2.length) {

            if (array1[left] < array2[right]) {
                left++;
            }
            else if (array1[left] > array2[right]) {
                right++;
            }
            // Jab bhi dono elem same hoga tab usme se ek choose krke dono pointer move.
            // Pick elem only from one of the array so that less confusion
            else {
                if (last != array2[right]) {
                    ansArray.add(array2[right]);
                    last = array2[right];
                }

                left++;
                right++;
            }
        }

        return ansArray;
    }
}
