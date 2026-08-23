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
        System.out.println("Median = " + findMedianSortedArrays2(nums1, nums2));

        sc.close();
    }

    // Solution 2:
    // TC → O(n1 + n2)
    // SC → O(1)
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n1 = nums1.length; // nums1 ki length
        int n2 = nums2.length; // nums2 ki length

        int n = n1 + n2; // Dono arrays ko combine karne par total elements

        int index2 = n / 2; // Median ka right/second index
        int index1 = index2 - 1; // Median ka left/first index

        int count = 0; // Virtual merged array mein current index track karega

        int elem1 = -1, elem2 = -1; // Median ke 2 required elements store karenge

        int i = 0, j = 0; // i -> nums1, j -> nums2 ko traverse karega


        // Dono arrays mein elements available hain tab tak compare karenge
        while (i < n1 && j < n2) {

            // nums1 ka current element chhota hai
            if (nums1[i] < nums2[j]) {

                // Agar current position median ke left index par hai
                if (count == index1) {
                    elem1 = nums1[i]; // Left median element store karo
                }

                // Agar current position median ke right index par hai
                if (count == index2) {
                    elem2 = nums1[i]; // Right median element store karo
                }

                count++; // Virtual merged array ka index increase
                i++; // nums1 mein next element par move
            }

            // nums2 ka current element chhota/equal hai
            else {

                // Agar current position median ke left index par hai
                if (count == index1) {
                    elem1 = nums2[j]; // Left median element store karo
                }

                // Agar current position median ke right index par hai
                if (count == index2) {
                    elem2 = nums2[j]; // Right median element store karo
                }

                count++; // Virtual merged array ka index increase
                j++; // nums2 mein next element par move
            }
        }


        // Agar nums1 mein abhi elements bach gaye hain
        while (i < n1) {

            // Median ke left element ko find karo
            if (count == index1) {
                elem1 = nums1[i];
            }

            // Median ke right element ko find karo
            if (count == index2) {
                elem2 = nums1[i];
            }

            count++; // Next virtual index
            i++; // nums1 ka next element
        }


        // Agar nums2 mein abhi elements bach gaye hain
        while (j < n2) {

            // Median ke left element ko find karo
            if (count == index1) {
                elem1 = nums2[j];
            }

            // Median ke right element ko find karo
            if (count == index2) {
                elem2 = nums2[j];
            }

            count++; // Next virtual index
            j++; // nums2 ka next element
        }


        // Agar total elements odd hain
        if (n % 2 == 1) {
            return elem2; // Sirf middle/right element hi median hoga
        }

        // Agar total elements even hain
        // Median = dono middle elements ka average
        return (double) (elem1 + elem2) / 2.0;
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
