package BinarySearch.BinarySearchOn2dArrays;

import java.util.Scanner;

public class SearchIn2DMatrixII {
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

        System.out.println("Using Brute: " + searchMatrixBrute(matrix, target));
        System.out.println("Using Better: " + searchMatrixBetter(matrix, target));

        sc.close();
    }

    // Better
    // Solution 2 : Har row ko one by one check karenge
    // TC : O(n * log(m))
    // SC : O(1)
    public static boolean searchMatrixBetter(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            int left = 0;
            int right = matrix[i].length - 1;

            // Current row par Binary Search lagayenge
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    // Brute
    // Solution 1 : Nested Loop Traversal
    // TC : O(n * m)
    // SC : O(1)
    public static boolean searchMatrixBrute(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
