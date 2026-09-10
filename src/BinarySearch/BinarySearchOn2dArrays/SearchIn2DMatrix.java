package BinarySearch.BinarySearchOn2dArrays;

import java.util.Scanner;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Target found: " + searchMatrixOptimal(matrix, target));
        System.out.println("Target found: " + searchMatrixBrute(matrix, target));

        sc.close();
    }

    // Solution 2 : Treating 2d array as 1d array and applying BS
    // TC : O(log(n * m))
    // SC : O(1)
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {

        int left = 0; // points to [0][0]
        int right = matrix.length * matrix[0].length - 1; // points to [m-1][n-1]

        while (left <= right) {

            int mid = left + (right - left) / 2; // calculating normal mid index

            // finding 2d matrix index using mid
            int row = mid / matrix[0].length; // row = index / no. of columns
            int col = mid % matrix[0].length; // col = index % no. of columns

            // normal BS operations
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Solution 1 : Applying BS on individual rows
    // But this is not accepted on leetcode bcz of Restriction
    // Line 26: The solution performs a linear scan of the rows, resulting in O(m log n) time complexity.
    public static boolean bs(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        // Agar target current row ke range mein nahi hai
        if (array[0] > target || array[right] < target) {
            return false;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Solution 1 : Applying BS on individual rows
    // TC : O(n * log(m))
    // SC : O(1)
    public static boolean searchMatrixBrute(int[][] matrix, int target) {

        for (int[] ints : matrix) {

            if (bs(ints, target)) {
                return true;
            }
        }

        return false;
    }
}