package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// Pattern : Binary search on Answers
public class KthMissingPositiveNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Kth missing positive number: " + kthMissingPositive(nums, k));

        sc.close();
    }

    // curr selected value ke pahle kitne positive numbers missing hain ye calculate karta hai.
    public static int prevTotalMissing(int[] nums, int curr) {

        int i = 0;
        int count = 0;

        // Sorted array hai toh hum ye check krenge ki curr value ke pahle kitni values usse chhoti ya equal present hain array me.
        while (i < nums.length && nums[i] <= curr) {
            count++;
            i++;
        }

        // curr tak jitne total numbers hain usme se present numbers minus kr denge toh kitne numbers missing hain vo pta chal jaayega.
        return curr - count;
    }

    // TC: O(N * log(max + k))
    // SC: O(1)
    public static int kthMissingPositive(int[] nums, int k) {

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        // Answer minimum 1 se start hoga.
        int left = 1;

        // Agar array ke andar 1 se leke sabhi elements present hain and hum array ki length se jyada k puch lein,
        // toh maximum possible answer max + k ho sakta hai, usse aage nahi jaayega.
        int right = max + k;

        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Jo value humne select kiya hai, hum dekhenge ki usse pahle kitne numbers missing hain.
            int prevTotalMissing = prevTotalMissing(nums, mid);

            // Agar mid tak k ya usse zyada numbers missing hain,
            // matlab mera mid kth missing positive ya uske baad ka missing positive hai.
            if (prevTotalMissing >= k) {

                // Toh us time hum ans ko store kar lenge.
                ans = mid;

                // Usse bhi chhote possible answer ke liye check karenge, isliye right side ko trim kar do.
                right = mid - 1;

            } else {

                // Agar total missing numbers mid tak k se kam hain,
                // toh iska matlab mera kth missing positive kahin aage aayega, isliye left side ko trim kar do.
                left = mid + 1;
            }
        }

        return ans;
    }


    // TC : O(log n)
    // SC : O(1)s
    public static int kthMissingPositive2(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // nums[mid] ke phle kitne positive numbers missing hain
            int prevMissing = nums[mid] - mid - 1;

            // Agar mid tak k ya usse zyada numbers missing hain toh kth missing number left side mein ho sakta hai
            if (prevMissing >= k) {
                right = mid - 1;

            } else {
                // Agar k se kam numbers missing hain toh kth missing number right side mein hoga
                left = mid + 1;
            }
        }

        // left vo position store karega jahan se kth missing number milega left + k karne par kth missing positive number mil jayega
        return left + k;
    }
}