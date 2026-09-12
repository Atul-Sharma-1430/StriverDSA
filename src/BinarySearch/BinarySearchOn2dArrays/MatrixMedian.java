package BinarySearch.BinarySearchOn2dArrays;

import java.util.Arrays;
import java.util.Scanner;

// it is given that num of rows and cols will always be odd
// Each row is sorted
public class MatrixMedian {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] array = new int[rows][cols];

        System.out.println("Enter array elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        double median = findMedianBrute(array);

        System.out.println("Median = " + median);

        sc.close();
    }

    // TC : O((m * n) log(m * n))
    // SC : O(m * n)
    public static double findMedianBrute(int[][] array) {

        // 2D ko ek 1d me convert kr rhe hain
        int[] oneDArray = new int[array.length * array[0].length];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                oneDArray[index++] = array[i][j];
            }
        }

        // Sort
        Arrays.sort(oneDArray);

        // Middle elem return kr do
        return oneDArray[oneDArray.length / 2];
    }
}