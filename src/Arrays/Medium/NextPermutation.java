package Arrays.Medium;

import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        nextPermutation(array);

        System.out.println("Next Permutation:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    /*
     * Time Complexity: O(n)
     * - Finding the breakpoint: O(n)
     * - Finding the next greater element: O(n)
     * - Reversing the suffix: O(n)
     * Overall: O(n)
     *
     * Space Complexity: O(1)
     */
    public static void nextPermutation(int[] nums) {

        int brkpt = -1;
        // find the index from right side from where value starts decreasing
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                brkpt = i;
                break;
            }
        }

        // if we didnt got any index means the array given is the last permutation hence reverse the array to go to first permutation
        if (brkpt == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
            return;
        }

        // brk point milne ke baad right side se pahli value aisi dhundo jo brkpt wale value se just badi ho and un dono ko swap kr do taaki prefix me jo value hai vo given array ke prefix value se just badi ho jaaye
        for (int i = nums.length - 1; i > brkpt; i--) {
            if (nums[i] > nums[brkpt]) {
                int temp = nums[i];
                nums[i] = nums[brkpt];
                nums[brkpt] = temp;
                break;
            }
        }

        // then brkpt se leke last tak poora array reverse kr do kyuki next greater prefix milne ke baad aage ki sab value ko sabse minimum rakhna hai toh reverse kyuki brkpt tabhi mila hoga jab koi chhoti value aayi matlab uske pahle ki sab values decreasing sorted order me hi thi
        int left = brkpt + 1;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}