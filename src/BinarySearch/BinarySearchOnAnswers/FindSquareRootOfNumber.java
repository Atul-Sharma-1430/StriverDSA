package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindSquareRootOfNumber {
    // TC : O(log n)
    // SC : O(1)
    public static int floorSqrt(int n) {
        int left = 1;
        int right = n / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Floor Square Root = " + floorSqrt(n));

        sc.close();
    }
}
