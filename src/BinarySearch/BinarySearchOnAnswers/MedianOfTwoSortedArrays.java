package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] nums1 = new int[n1];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));

        sc.close();
    }

    // Solution 1:
    // TC : O(n + m)
    // SC : O(n + m)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Dono sorted arrays ko merge karke ek sorted array banayenge
        int[] sortedArray = new int[nums1.length + nums2.length];

        // pointer1 -> nums1 ke current element ko point karega
        // pointer2 -> nums2 ke current element ko point karega
        int pointer1 = 0;
        int pointer2 = 0;

        int i;

        // Jab tak dono arrays mein elements available hain, dono current elements ko compare karke chhota element sortedArray mein add karenge
        for (i = 0; i < sortedArray.length && (pointer1 < nums1.length && pointer2 < nums2.length); i++) {

            // Agar nums1 ka current element chhota hai
            if (nums1[pointer1] < nums2[pointer2]) {
                // nums1 ka element sortedArray mein add karo
                sortedArray[i] = nums1[pointer1];
                // nums1 ka pointer aage badhao
                pointer1++;

            } else {
                // Otherwise nums2 ka current element add karo
                sortedArray[i] = nums2[pointer2];
                // nums2 ka pointer aage badhao
                pointer2++;
            }
        }

        // Ab ek array completely traverse ho chuka hai.Doosre array ke remaining elements ko sortedArray mein add karenge.
        for (int j = i; j < sortedArray.length; j++) {

            // Agar nums1 mein elements remaining hain
            if (pointer1 != nums1.length) {
                sortedArray[j] = nums1[pointer1];
                pointer1++;
            }

            // Agar nums2 mein elements remaining hain
            if (pointer2 != nums2.length) {
                sortedArray[j] = nums2[pointer2];
                pointer2++;
            }
        }

        // Sorted array ka middle index
        int mid = sortedArray.length / 2;

        // Agar total elements odd hain toh middle element hi median hoga
        if (sortedArray.length % 2 != 0) {
            return sortedArray[mid];
        } else {
            // Agar total elements even hain,
            // toh middle ke dono elements ka average median hoga
            return (sortedArray[mid] + sortedArray[mid - 1]) / 2.00;
        }
    }
}
