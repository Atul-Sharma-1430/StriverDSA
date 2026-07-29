package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        List<Integer> ans = spiralOrder(matrix);

        System.out.println("Spiral Order:");
        System.out.println(ans);

        sc.close();
    }

    // TC : O(n * m)
    // SC : O(1) not taking the output list in space
    public static List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // Top Row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }

            // Right Column
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            // Bottom Row
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }

            // Left Column
            if (left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }

            top++;
            right--;
            bottom--;
            left++;
        }

        return ans;
    }
}