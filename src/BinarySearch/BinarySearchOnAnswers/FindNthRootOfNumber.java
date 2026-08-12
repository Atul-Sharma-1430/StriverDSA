package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindNthRootOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = nthRoot(num, n);

        if (result == -1) {
            System.out.println("Nth root does not exist");
        } else {
            System.out.println("Nth root = " + result);
        }

        sc.close();
    }

    // TC : O(log num * n)
    // SC : O(1)
    public static int nthRoot(int num, int n) {
        int left = 1;
        int right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int temp = 1;
            for (int i = 1; i <= n; i++) {
                temp *= mid;

                if (temp > num) {
                    break;
                }
            }

            if (temp == num) {
                return mid;
            } else if (temp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}