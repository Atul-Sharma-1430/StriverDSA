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

    // TC : O(log(min(n1, n2)))
    // SC : O(1)
    public int kthElement(int[] nums1, int[] nums2, int k) {

        // Binary Search hamesha smaller array par karenge taaki Time Complexity O(log(min(n1, n2))) rahe
        if (nums1.length > nums2.length) {
            return kthElement(nums2, nums1, k);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        // nums1 se minimum itne elements lene pad sakte hain agar nums2 mein elements kam pad jaaye
        int low = Math.max(0, k - n2);

        // nums1 se maximum k elements hi le sakte hain aur array ki length se zyada nahi
        int high = Math.min(k, n1);

        while (low <= high) {

            // Binary Search se nums1 mein current partition position find kar rahe hain
            int partition1 = low + (high - low) / 2;

            // Total k elements left partition mein chahiye, isliye baaki elements nums2 se lenge
            int partition2 = k - partition1;

            int left1; // nums1 ke left partition ka last element
            int right1; // nums1 ke right partition ka first element
            int left2; // nums2 ke left partition ka last element
            int right2; // nums2 ke right partition ka first element

            // Agar nums1 se left partition mein koi element nahi liya toh smallest possible value maanenge
            if (partition1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[partition1 - 1]; // Partition ke just left wala nums1 ka element
            }

            // Agar nums1 ke saare selected elements left partition mein hain toh largest possible value maanenge
            if (partition1 == n1) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[partition1]; // Partition ke just right wala nums1 ka element
            }

            // Agar nums2 se left partition mein koi element nahi liya toh smallest possible value maanenge
            if (partition2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[partition2 - 1]; // Partition ke just left wala nums2 ka element
            }

            // Agar nums2 ke saare elements left partition mein hain toh largest possible value maanenge
            if (partition2 == n2) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[partition2]; // Partition ke just right wala nums2 ka element
            }

            // Correct partition tab milega jab dono arrays ke left elements dono right elements se chhote ya equal hon
            if (left1 <= right2 && left2 <= right1) {

                // Correct partition mein left side ke maximum element ko return karenge because wahi kth element hai
                return Math.max(left1, left2);

            } else if (left1 > right2) {

                // left1 bada hai matlab nums1 se zyada elements liye, isliye partition ko left move karenge
                high = partition1 - 1;

            } else {

                // left2 bada hai matlab nums1 se kam elements liye, isliye partition ko right move karenge
                low = partition1 + 1;
            }
        }

        // Valid input ke case mein yaha normally kabhi nahi aayega
        return -1;
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