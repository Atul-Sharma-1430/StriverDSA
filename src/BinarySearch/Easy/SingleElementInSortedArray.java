package BinarySearch.Easy;

import java.util.Scanner;

public class SingleElementInSortedArray {
    // TC: O(n), SC: O(1)
    public static int singleNonDuplicate1(int[] nums) {
        int xorAll = 0;

        // Same elements ka XOR 0 ho jayega aur single element bach jayega.
        for (int num : nums) {
            xorAll ^= num;
        }

        // XOR ke baad jo value bachegi wahi single element hai.
        return xorAll;
    }

    // TC: O(log n), SC: O(1)
    public static int singleNonDuplicate2(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Mid ko even index par la rahe hain taaki mid aur mid+1 ki pair check kar sake.
            if (mid % 2 != 0) {
                mid--;
            }

            // Agar mid aur mid+1 same hain toh pair correct hai aur single element right side mein hoga.
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }

            // Agar pair match nahi hui toh single element mid ya uske left side mein hoga.
            else {
                right = mid;
            }
        }

        // Jab left aur right same ho jayenge toh wahi single element ka index hoga.
        return nums[left];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Single Element using XOR: " + singleNonDuplicate1(nums));
        System.out.println("Single Element using Binary Search: " + singleNonDuplicate2(nums));

        sc.close();
    }
}