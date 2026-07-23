package Arrays.Medium;

import java.util.Arrays;
import java.util.Scanner;

class RearrangeArrayBySign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(rearrangeArray2(array)));

        sc.close();
    }

    // If number of positive and negative elements are same
    // TC : O(n)
    // SC : O(n)
    public static int[] rearrangeArray(int[] nums) {
        int[] ansArray = new int[nums.length];

        int pIndex = 0;
        int nIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ansArray[pIndex] = nums[i];
                pIndex += 2;
            } else {
                ansArray[nIndex] = nums[i];
                nIndex += 2;
            }
        }

        return ansArray;
    }

    // If number of positive and negative elements are not same
    // TC : O(n)
    // SC : O(n)
    public static int[] rearrangeArray2(int[] nums) {
        int pCount = 0;
        int nCount = 0;

        // Count positive and negative elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nCount++;
            } else {
                pCount++;
            }
        }

        int[] pArray = new int[pCount];
        int[] nArray = new int[nCount];

        int pIndex = 0;
        int nIndex = 0;

        // Store positives and negatives separately
        for (int val : nums) {
            if (val >= 0) {
                pArray[pIndex] = val;
                pIndex++;
            } else {
                nArray[nIndex] = val;
                nIndex++;
            }
        }

        int index = 0;
        int p = 0;
        int n = 0;

        // Place elements alternately
        for (int i = 0; i < Math.min(pCount, nCount); i++) {
            nums[index] = pArray[i];
            p++;
            nums[index + 1] = nArray[i];
            n++;
            index += 2;
        }

        // Add remaining positive elements
        while (p < pArray.length) {
            nums[index] = pArray[p];
            index++;
            p++;
        }

        // Add remaining negative elements
        while (n < nArray.length) {
            nums[index] = nArray[n];
            index++;
            n++;
        }

        return nums;
    }
}
