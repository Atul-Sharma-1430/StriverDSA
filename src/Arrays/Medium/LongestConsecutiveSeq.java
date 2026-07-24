package Arrays.Medium;

import java.util.Scanner;

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

        System.out.println("Longest Consecutive Sequence Length: " + lcs(array));

        sc.close();
    }

    // TC: O(n^2)
    // SC: O(1)
    public static int lcs(int[] nums) {

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
}