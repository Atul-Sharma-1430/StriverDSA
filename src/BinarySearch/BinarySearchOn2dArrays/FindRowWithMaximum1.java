package BinarySearch.BinarySearchOn2dArrays;

import java.util.Scanner;

public class FindRowWithMaximum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] nums = new int[n][m];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        System.out.println("Row with maximum 1s: " + rowWithMaxOneBrute(nums));
        System.out.println("Row with maximum 1s: " + rowWithMaxOneBS(nums));

        sc.close();
    }

    // Har row mein binary search laga kar number of 1s count karenge
    // Concept of lower bound
    public static int calculate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int index = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Agar 1 mila toh aur left side mein first 1 search karenge
            if (nums[mid] == 1) {
                right = mid - 1;
                index = mid;
            } else {
                // Agar 0 mila toh right side mein search karenge
                left = mid + 1;
            }
        }

        // Agar row mein ek bhi 1 nahi mila
        if (index == -1) {
            return 0;
        }

        // First 1 ke baad jitne elements hain wahi total 1s hain
        return nums.length - index;
    }

    // Har row par binary search laga kar maximum 1s wali row find karenge
    // TC : O(n * log(m))
    // SC : O(1)
    public static int rowWithMaxOneBS(int[][] nums) {

        int row = -1;
        int maxOnes = 0;

        // Har row ko individually check karenge
        for (int i = 0; i < nums.length; i++) {

            // Current row mein total 1s count karenge
            int ones = calculate(nums[i]);

            // Agar current row mein zyada 1s hain
            if (ones > maxOnes) {
                maxOnes = ones;
                row = i;
            }
        }

        return row;
    }

    // Brute force approach
    // Har row ke har element ko check karenge
    // TC : O(n * m)
    // SC : O(1)
    public static int rowWithMaxOneBrute(int[][] nums) {

        int row = -1;
        int maxCount = 0;

        // Har row ko traverse karenge
        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            // Current row ke saare elements check karenge
            for (int j = 0; j < nums[i].length; j++) {

                // Agar element 1 hai toh count increase karenge
                if (nums[i][j] == 1) {
                    count++;
                }
            }

            // Agar current row mein maximum 1s hain
            if (count > maxCount) {
                maxCount = count;
                row = i;
            }
        }

        return row;
    }
}