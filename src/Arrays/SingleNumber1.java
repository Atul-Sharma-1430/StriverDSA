package Arrays;

import java.util.Scanner;

public class SingleNumber1 {
    public static int findSingleNumber(int[] nums) {
        int ans = 0;

        // XOR bits par kaam karta hai aur uska rule aisa hai ki agar same bit/value do baar XOR ho, toh pehle wala effect undo ho jata hai.
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findSingleNumber(nums);

        System.out.println("Single Number: " + result);

        sc.close();
    }
}
