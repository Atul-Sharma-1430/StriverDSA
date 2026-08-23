package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// Similar approach as Median of Two Sorted Arrays
public class KthElementOf2SortedArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of nums1: ");
        int n1 = sc.nextInt();

        int[] nums1 = new int[n1];

        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];

        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("Kth Element = " + findKthElement(nums1, nums2, k));

        sc.close();
    }

    // Solution 1:
    // TC → O(n1 + n2)
    // SC → O(1)
    public static int findKthElement(int[] nums1, int[] nums2, int k) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int count = 1; // Kth element ko 1-based indexing se count karenge

        int i = 0; // nums1 ka pointer
        int j = 0; // nums2 ka pointer

        // Dono arrays mein elements available hain
        while (i < n1 && j < n2) {

            // nums1 ka current element chhota hai
            if (nums1[i] < nums2[j]) {

                // Agar current element kth position par hai
                if (count == k) {
                    return nums1[i];
                }

                count++; // Next position
                i++; // nums1 ka next element

            } else {

                // Agar current element kth position par hai
                if (count == k) {
                    return nums2[j];
                }

                count++; // Next position
                j++; // nums2 ka next element
            }
        }

        // nums1 mein elements bach gaye
        while (i < n1) {

            if (count == k) {
                return nums1[i];
            }

            count++;
            i++;
        }

        // nums2 mein elements bach gaye
        while (j < n2) {

            if (count == k) {
                return nums2[j];
            }

            count++;
            j++;
        }

        // Kth element nahi mila
        return -1;
    }
}