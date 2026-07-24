package Arrays.Medium;

import java.util.*;

public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Leaders in the array: " + findLeaders(array));

        sc.close();
    }

    /*
     * TC: O(n)
     * SC: O(1) Auxiliary Space
     * Note: The output ArrayList is not counted in auxiliary space.
     * If output space is considered, SC = O(k), where k is the number of leaders.
     */
    public static ArrayList<Integer> findLeaders(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();

        int maxTillNow = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i == nums.length - 1) {
                ans.add(nums[i]);
                maxTillNow = nums[i];
            } else if (nums[i] > maxTillNow) {
                ans.add(nums[i]);
                maxTillNow = nums[i];
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}