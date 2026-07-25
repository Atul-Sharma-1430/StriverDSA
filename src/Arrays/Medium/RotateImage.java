package Arrays.Medium;

import java.util.*;

public class RotateImage {
    // TC : O(n^2)
    // SC : O(n^2)
    public static void rotateImage(int[][] matrix) {

        int [][] ansMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ansMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(ansMatrix[i], 0, matrix[i], 0, matrix.length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        rotateImage(matrix);
        System.out.println("Matrix after rotation:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
