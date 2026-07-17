package Arrays.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class DutchFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements(only 0 1 and 2)");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(optimal2(array)));

        sc.close();
    }

    public static int[] optimal2(int[] array) {
        // variables to store the frequency of each element
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        // Count Frequency of each elem
        for (int j : array) {
            if (j == 0) zeros++;
            else if (j == 1) ones++;
            else twos++;
        }

        int index = 0;

        // Place all zeros
        while(zeros != 0) {
            array[index] = 0;
            index++;
            zeros--;
        }

        // Place all ones
        while(ones != 0) {
            array[index] = 1;
            index++;
            ones--;
        }

        // Place all twos
        while(twos != 0) {
            array[index] = 2;
            index++;
            twos--;
        }

        return array;
    }

    public static int[] optimal(int[] array) {
        int trackZero = 0; // Tracks the Zero from left
        int trackCurrEl = 0; // Tracks current element and places 1 at its right position
        int trackTwo = array.length-1; // Tracks two from right

        while(trackCurrEl <= trackTwo) {
            // If current element is 0 then place it to start
            if(array[trackCurrEl] == 0) {
                int temp = array[trackCurrEl];
                array[trackCurrEl] = array[trackZero];
                array[trackZero] = temp;
                trackCurrEl++;
                trackZero++;
            }
            // if one then move ahead
            else if(array[trackCurrEl] == 1) {
                trackCurrEl++;
            }
            // else it will be 2 so place it to right side
            else {
                int temp = array[trackCurrEl];
                array[trackCurrEl] = array[trackTwo];
                array[trackTwo] = temp;
                trackTwo--;
            }
        }

        return array;
    }
}
