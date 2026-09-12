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

    // ==================== OPTIMAL =====================
    // TC : O(log(max - min) * m * log(n))
    // SC : O(1)
    // Ye function first element jo x se strictly greater hai uska index return karega
    public static int upperBound(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;

        // Agar x se bada koi element nahi mila to array ki length return hogi
        // Iska matlab saare elements <= x hain
        int ans = array.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Agar current element x se bada hai
            if (array[mid] > x) {
                // Ye ek possible upper bound ho sakta hai
                ans = mid;
                // Dekhenge kya isse pehle bhi koi x se bada element mil sakta hai
                high = mid - 1;
            } else {
                // array[mid] <= x hai to right side check karenge
                low = mid + 1;
            }
        }

        return ans;
    }

    // Ye function matrix me total kitne elements x se less than ya equal hain vo count karega
    public static int countSmallEqual(int[][] array, int x) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            // upperBound ka index basically row me <= x elements ki count hoti hai
            count += upperBound(array[i], x);
        }

        return count;
    }


    // Optimal approach
    // Binary Search on Answers
    public static int findMedianOptimal(int[][] array) {

        // Low ko matrix ke minimum possible value se initialize karenge
        int low = Integer.MAX_VALUE;
        // High ko matrix ke maximum possible value se initialize karenge
        int high = Integer.MIN_VALUE;

        // Har row sorted hai isliye first element minimum aur last element maximum hoga
        for (int i = 0; i < array.length; i++) {
            // Sabhi rows ke first element me se minimum find karenge
            low = Math.min(low, array[i][0]);
            // Sabhi rows ke last element me se maximum find karenge
            high = Math.max(high, array[i][array[i].length - 1]);
        }

        // Median ke left side me kitne elements hone chahiye
        int req = (array.length * array[0].length) / 2;

        // Minimum value se maximum value ke beech binary search karenge
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Matrix me kitne elements mid se <= hain vo count karenge
            int smallEql = countSmallEqual(array, mid);

            // Agar <= mid elements required count se kam ya equal hain
            // To median mid se bada ho sakta hai
            if (smallEql <= req) {
                low = mid + 1;
            } else {

                // Agar required se jyada elements <= mid hain
                // To median mid ya mid se chhota ho sakta hai
                high = mid - 1;
            }
        }

        // Low finally median par point karega
        return low;
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