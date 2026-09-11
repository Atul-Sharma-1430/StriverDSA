package BinarySearch.BinarySearchOn2dArrays;

import java.util.Scanner;

public class FindPeakElementII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int[] optimal = findPeakGridOptimal(mat);
        System.out.println("Optimal: [" + optimal[0] + ", " + optimal[1] + "]");

        int[] brute2 = findPeakGridBrute2(mat);
        System.out.println("Brute 2: [" + brute2[0] + ", " + brute2[1] + "]");

        int[] brute = findPeakGridBrute(mat);
        System.out.println("Brute: [" + brute[0] + ", " + brute[1] + "]");

        sc.close();
    }

    // Optimal Soln
    // TC : O(m * log(n))
    // SC : O(1)
    // Basically hum har mid wali row ka maximun value (not peak)
    // kyuki 2d array me dekhenge to max wali value ke peak hone ke chances jyada hai
    // isliye max find krna hain as peak
    // Kyuki row ka maximum element left aur right neighbours se already bada hoga
    public static int findPeak(int[] array) {

        int index = 0;

        // ye hum peak elem hi nikaal rhe hain but hum max wala peak choose krenge
        // kyuki uska chances jyada h
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[index]) {
                index = i;
            }
        }

        return index;
    }

    public static int[] findPeakGridOptimal(int[][] mat) {

        int low = 0;
        int high = mat.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Current row mein left-right peak find karenge
            int index = findPeak(mat[mid]);

            // Current element ke upar aur neeche wale elements check
            int up;
            int down;

            // agar first row hai toh
            if (mid > 0) {
                up = mat[mid - 1][index];
            } else {
                up = -1;
            }

            // agar last row hai toh
            if (mid < mat.length - 1) {
                down = mat[mid + 1][index];
            } else {
                down = -1;
            }

            // Agar current element dono upr niche neighbours se bada hai toh elem peak hai
            if (mat[mid][index] > up && mat[mid][index] > down) {
                return new int[]{mid, index};
            }

            // Agar upar wala element bada hai toh us side move kro jaise pahle wale me kiye the
            if (up > mat[mid][index]) {
                high = mid - 1;
            }

            // Agar neeche wala element bada hai toh niche
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }


    // ==================== Brute 2 ====================

    // Brute 2
    // Find larget element cz it it will always be peak elem
    // TC : O(n * m)
    // SC : O(1)
    public static int[] findPeakGridBrute2(int[][] mat) {

        int largest = Integer.MIN_VALUE;

        int row = -1;
        int col = -1;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] > largest) {
                    largest = mat[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }


    // ==================== Brute ====================

    // Brute
    // TC : O(n*m*4)
    // SC : O(1)
    // Har element ke liye charo side check kro
    public static int[] findPeakGridBrute(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                // Left
                if (j - 1 >= 0 && mat[i][j - 1] >= mat[i][j]) {
                    continue;
                }

                // Right
                if (j + 1 < mat[i].length && mat[i][j + 1] >= mat[i][j]) {
                    continue;
                }

                // Up
                if (i - 1 >= 0 && mat[i - 1][j] >= mat[i][j]) {
                    continue;
                }

                // Down
                if (i + 1 < mat.length && mat[i + 1][j] >= mat[i][j]) {
                    continue;
                }

                // Current element is greater than all valid neighbours
                return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }
}