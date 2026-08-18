package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// This problem is same as Split Array problem exactly same
// TC : O(n log(sum - max))
// SC : O(1)

// Pattern : Binary search on answers ====> (min) max OR (max) min
// In this pattern is min of max
public class PaintersPartition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of boards: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter length of each board:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of painters: ");
        int k = sc.nextInt();

        System.out.println("Minimum possible maximum time = " + splitArray(nums, k));

        sc.close();
    }

    // given maximum time ke andar kya boards ko k painters mein divide kar sakte hain
    public static boolean isPossible(int[] nums, int hrs, int k) {

        // Pehla painter boards paint karna start karega
        int total = 1;

        // Current painter ne abhi tak jitne boards paint kiye hain unka total time
        int time = 0;

        for (int i = 0; i < nums.length; i++) {

            // Agar current board paint karne ke baad current painter ka total time maximum limit se exceed ho raha hai
            if (time + nums[i] > hrs) {

                // Current board ko next painter ko allocate karenge
                total++;

                // PNaye painter ka painting time current board se start hoga
                time = nums[i];

            } else {

                // Agar maximum time exceed nahi ho raha toh current board same painter ko de do
                time += nums[i];
            }
        }

        // Agar required k painters ke andar saare boards allocate ho rahe hain
        return total <= k;
    }

    public static int splitArray(int[] nums, int k) {

        // Agar painters boards se zyada hain toh har painter ko at least ek board dena possible nahi hai
        if (nums.length < k) {
            return -1;
        }

        // Binary search ki range find kar rahe hain
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Maximum single board ki length find kar rahe hain
            // Kyuki ek board ko split nahi kar sakte
            max = Math.max(max, nums[i]);

            // Saare boards ki total length find kar rahe hain
            // Maximum possible time mein ek painter saare boards paint kar sakta hai
            sum += nums[i];
        }

        // Minimum possible maximum time = maximum length wale board ka time
        // Isse kam time mein maximum board paint hi nahi ho sakta
        int left = max;

        // Maximum possible time = saare boards ki total length
        // Agar sirf ek painter ho toh woh saare boards paint karega
        int right = sum;

        while (left <= right) {

            // Current maximum allowed painting time
            int mid = left + (right - left) / 2;

            // Check karenge ki kya mid maximum time ke andar
            // saare boards ko k painters mein allocate kar sakte hain
            boolean possible = isPossible(nums, mid, k);

            if (possible) {

                // Agar current maximum time possible hai
                // toh hum aur kam maximum time try karenge
                // Kyuki hume minimum possible maximum time chahiye
                right = mid - 1;

            } else {

                // Agar current maximum time possible nahi hai
                // toh painters ko boards allocate karne ke liye maximum time badhana padega
                left = mid + 1;
            }
        }

        // Binary search ke end mein left minimum possible maximum painting time hoga
        return left;
    }
}