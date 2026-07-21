package Arrays.Medium;

import java.util.Scanner;

class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int [] array = new int[size];
        System.out.print("Enter " + size + " numbers: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(KadaneAlgo(array));

        sc.close();
    }

    // Checking all Subarrays;
    // TC : O(n2)
    // SC : O(1)
    public static int brute(int[] array) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];

                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    // TC : O(n)
    // SC : O(1)
    public static int KadaneAlgo(int[] array) {
        int currSum = 0; // Stores the sum of subarray
        int maxSum = Integer.MIN_VALUE; // Stores max value

        for (int num : array) {
            currSum += num; // add curr element

            maxSum = Math.max(currSum, maxSum);// Update maxSum if currSum > maxSum

            if (currSum <= 0) currSum = 0; // if anywhere sum becomes zero or negative means no need to carry previous elements sum as they will not give maxSum on adding further elements
        }

        // If mentioned do not return negative sum;
        // If all the array value is negative then it may return a negative value
        if(maxSum < 0) {
            return -1;
        }

        return maxSum;
    }
}
