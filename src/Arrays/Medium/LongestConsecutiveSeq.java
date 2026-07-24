package Arrays.Medium;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

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

        System.out.println("Longest Consecutive Sequence Length: " + lcsOptimal(array));

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

    // TC : O(n)
    // SC : O(n)
    public static int lcsOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // Add all unique elements in set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // stores max len
        int maxLen = 0;

        // Iterating over set not array cause array san give TLE
        for (int num : set) {
            // if the prev elem of current element does not exist means curr num can be our
            // starting num of seq
            if (!set.contains(num - 1)) {

                // if we get starting num then check for it next further elements
                int count = 1; // hence, count as 1 for the starting element
                int j = 1; // a variable which keeps increasing to get next-next values

                // if set contains next value then increase count and also j to get further next
                // element
                while (set.contains(num + j)) {
                    j++;
                    count++;
                }

                // Update maxLen if count is greater than maxLen
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}