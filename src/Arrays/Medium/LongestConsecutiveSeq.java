package Arrays.Medium;

import java.util.Scanner;
import java.util.Arrays;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Longest Consecutive Sequence Length: " + lcsBrute(array));

        sc.close();
    }

    // TC: O(n^2)
    // SC: O(1)
    public static int lcsBrute(int[] nums) {

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = 1;

            while (linearSearch(nums, current + 1)) {
                current++;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    // TC : O(n log n)
    // SC : O(1)
    public static int lcsBetter(int[] nums) {
        Arrays.sort(nums);

        int longest = 0; // stored the final ans
        int lastSmallest = Integer.MIN_VALUE;// stores last smallest value in order to get the seq

        int count = 0;// keeps the track of temporary length of subseq

        for (int i = 0; i < nums.length; i++) {
            // if same elems then skip
            if (nums[i] == lastSmallest) {
                continue;
            }
            // if elem if just greater than last smallest means it can be part of
            // subsequence hence count + 1 and make this elem as lastSmallest
            else if (nums[i] == lastSmallest + 1) {
                lastSmallest = nums[i];
                count++;
            }
            // if got a new elem which is not satisfying the current subseq condition then
            // make this as new lastSmallest and make count as 1
            else {
                count = 1;
                lastSmallest = nums[i];
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}