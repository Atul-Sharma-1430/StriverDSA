package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        List<List<Integer>> triangle = printPTriangle(rows);

        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    // Question 1 : Print pascals triangle
    // TC : O(rows²)
    // SC : O(rows²) (Output Space)
    public static List<List<Integer>> printPTriangle(int rows) {
        // Agar 0 row hua toh return kr do
        if (rows == 0) {
            return new ArrayList<>();
        }

        // List of list jo triangle ko store krega
        List<List<Integer>> pTriangle = new ArrayList<>();
        //firstly 1 put kr do cz uske pahle koi row nhi hai jisse vo generate kr sake so manually put 1
        pTriangle.add(new ArrayList<>(Arrays.asList(1)));

        // nested loop as its a 2d triangle
        for (int i = 1; i < rows; i++) {
            // har row ke liye ek diff list banegi jisko baad me triangle me add kr denge
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1); // har row ka first element 1 rhega toh manually add

            // since current row ko banane ke liye previous row ki help lagegi toh usey nikaal lo
            List<Integer> lastRow = pTriangle.get(pTriangle.size() - 1);

            // ab previous row ki j-1 and j index ki values ko add krke currRow me put kro
            // j starts from 1 bcz 0th index pe 1 already add kr diye hain and goes till less than i because last value 1 bhi manually add krenge
            for (int j = 1; j < i; j++) {
                currRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }

            // har row ka last element bhi 1 rhega toh manually add
            currRow.add(1);
            // currRow ko triangle me add kr do
            pTriangle.add(currRow);
        }

        return pTriangle;
    }

    // Question 2: If asked to print a particular value at given row, col
    // TC : O(col)
    // SC : O(1)
    public static int printValueAt(int row, int col) {
        return nCr(row - 1, col - 1);
    }

    private static int nCr(int n, int r) {

        if (r > n) {
            return 0;
        }

        if (r > n - r) {
            r = n - r;
        }

        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < r; i++) {
            numerator *= (n - i);
        }

        for (int i = 1; i <= r; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }

    // Question 3 : Print a particular row
    // TC : O(row²)
    // SC : O(1)
    public static void printRow(int row) {
        print(row);
    }

    private static void print(int row) {
        for (int i = 1; i <= row; i++) {
            System.out.print(printValueAt(row, i) + " ");
        }
    }

}