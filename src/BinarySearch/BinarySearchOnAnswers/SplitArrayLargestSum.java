package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// This problem is same as Painters problem exact same
// TC : O(n log(sum - max))
// SC : O(1)

// Pattern : Binary search on answers ====> (min) max OR (max) min
// In this pattern is min of max
public class SplitArrayLargestSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of subarrays: ");
        int k = sc.nextInt();

        System.out.println("Minimum possible maximum sum = " + splitArray(nums, k));

        sc.close();
    }

    // Ye function check karega ki given "hrs" maximum limit ke andar kya array ko maximum k parts/subarrays mein divide kar sakte hain
    public static boolean isPossible(int[] nums, int hrs, int k) {
        // Pehla subarray yahin se start kar rahe hain
        int total = 1;

        // Current subarray mein abhi tak ka total sum
        int time = 0;

        for (int i = 0; i < nums.length; i++) {

            // Agar current element add karne ke baad current subarray ka sum given maximum limit se exceed ho raha hai
            if (time + nums[i] > hrs) {
                // Current element ko naye subarray mein daalenge
                total++;

                // Naye subarray ka sum current element se start hoga
                time = nums[i];

            } else {
                // Agar maximum limit exceed nahi ho rahi toh current subarray mein current element add kar do
                time += nums[i];
            }
        }

        // Agar required k subarrays ke andar allocation possible hai
        return total <= k;
    }

    public static int splitArray(int[] nums, int k) {

        // Agar subarrays k se zyada chahiye aur elements hi kam hain toh har subarray mein at least ek element dena possible nahi hai
        if (nums.length < k) {
            return -1;
        }

        // Range of Binary Search
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Ek single element ko split nahi kar sakte isliye minimum possible answer maximum element hoga
            max = Math.max(max, nums[i]);

            // Maximum possible answer ke liye saare elements ka total sum le sakte hain
            sum += nums[i];
        }

        // Minimum possible answer kyuki maximum element se kam maximum sum possible nahi hai
        int left = max;
        // Maximum possible answer saare elements ek hi subarray mein aa sakte hain
        int right = sum;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check karenge ki kya mid maximum sum rakhkar array ko k parts mein divide karna possible hai
            boolean possible = isPossible(nums, mid, k);

            if (possible) {
                // Agar current maximum sum possible hai toh hum aur chhota answer try karenge
                // kyuki hume minimum possible maximum sum chahiye
                right = mid - 1;

            } else {
                // Agar current maximum sum possible nahi hai toh maximum allowed sum badhana padega
                left = mid + 1;
            }
        }

        // Binary search ke end mein left will be at minimum possible answer
        return left;
    }
}