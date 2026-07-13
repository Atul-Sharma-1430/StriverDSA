package Arrays.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("2nd largest by Brute :" + brute(array));
        System.out.println("2nd largest by Better :" + better(array));
        System.out.println("2nd largest by Optimal :" + optimal(array));

        sc.close();
    }

    // 10 11 14 12 23 4 25 78 96
    // TC = O(n)
    public static int optimal(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int j : array) {
            // Case 1: When we get a new largest element then the previous largest becomes second largest and new one will go in current largest
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            }
            // Case 2: When the current element is greater than secondLargest but less than or not equal largest at that time largest remains same but 2ndLargest changes
            else if (j > secondLargest && j != largest) {
                secondLargest = j;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    // 10 11 14 12 23 4 25 78 96
    // TC : O(n) + O(n) = O(2n) = O(n)
    public static int better(int [] array) {
        int largest = Integer.MIN_VALUE;

        for (int i : array) {
            if (i > largest) {
                largest = i;
            }
        }

        int secLargest = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > secLargest && i != largest) {
                secLargest = i;
            }
        }

        if (secLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secLargest;
    }

    // 10 11 14 12 23 4 25 78 96
    // TC = O(n log n)
    public static int brute(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);

        int largest = copy[copy.length - 1];

        for (int i = copy.length - 2; i >= 0; i--) {
            if (copy[i] != largest) {
                return copy[i];
            }
        }

        return -1;
    }
}
