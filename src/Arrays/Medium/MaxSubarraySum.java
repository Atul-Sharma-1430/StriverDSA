package Arrays.Medium;

import java.util.Scanner;
import java.util.Arrays;

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

        System.out.println(Arrays.toString(maxSubarray(array)));

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

    // If it is asked to return the subarray with maximum sum,
    // then along with maxSum we also need to track the start and end indexes.
    public static int[] maxSubarray(int[] array) {

        int sum = 0;

        // Stores the start index of the final answer subarray.
        int stIndex = -1;

        // Stores the end index of the final answer subarray.
        int endIndex = -1;

        // Tracks the starting index of the CURRENT subarray.
        // Isko directly stIndex nahi bana sakte.
        // Kyuki ho sakta hai current subarray baad me reject ho jaye.
        // Jab bhi naya maximum sum milega tabhi st ki value stIndex me save hogi.
        int st = 0;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            sum += array[i];

            // Agar current sum ne naya maximum banaya,
            // to current subarray hi answer ban jayegi.
            // Isliye uske start aur end indexes save kar do.
            if (sum > maxSum) {
                maxSum = sum;
                stIndex = st;
                endIndex = i;
            }

            // Agar sum negative ho gaya,
            // to iske aage continue karne ka koi fayda nahi.
            // Next subarray i+1 se start hogi.
            if (sum < 0) {
                sum = 0;
                st = i + 1;
            }
        }

        System.out.println(maxSum);

        int[] ansArray = new int[endIndex - stIndex + 1];

        int index = 0;

        // Copy the maximum sum subarray into the answer array.
        for (int i = stIndex; i <= endIndex; i++) {
            ansArray[index++] = array[i];
        }

        return ansArray;
    }
}
