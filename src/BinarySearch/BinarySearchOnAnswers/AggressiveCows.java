package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;
import java.util.Scanner;

// Pattern : Binary search on answers ====> (min) max OR (max) min
public class AggressiveCows {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter stall positions:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int cows = sc.nextInt();

        System.out.println("Maximum minimum distance = " + maxOfMinDist(nums, cows));

        sc.close();
    }

    public static boolean isPossible(int[] nums, int dist, int cows) {
        // Pehli cow ko first stall par place kar rahe hain
        int count = 1;

        // Last placed cow ka index
        int lastPlaced = 0;

        int i = 1;
        while (i < nums.length) {

            // Current stall aur last placed cow ke beech ka distance
            if (nums[i] - nums[lastPlaced] >= dist) {

                // Current stall par cow place kar do
                count++;

                // Ab current cow last placed cow ban gayi
                lastPlaced = i;
            }

            i++;
        }

        // Agar required number of cows place ho gayi
        return count >= cows;
    }

    // TC : O(n log n + n log(maxPosition))
    // SC : O(log n)  --> BCZ of sorting stack space
    public static int maxOfMinDist(int[] nums, int cows) {
        // Sort first
        Arrays.sort(nums);

        // Minimum possible distance
        int left = 1;

        // Maximum possible distance first aur last stall ke beech ka hoga
        int right = nums[nums.length - 1];

        int ans = -1;

        while (left <= right) {
            int dist = left + (right - left) / 2;

            boolean possible = isPossible(nums, dist, cows);

            if (possible) {
                // Current distance possible hai means ye ek possible ans ho skta hai but humey max chahiye minimun distances ka toh isliye right side check kro aur
                ans = dist;
                left = dist + 1;

            } else {
                // Current distance possible nahi hai means saaare cows place nhi ho paaye toh dist kam kro unke beech ka
                right = dist - 1;
            }
        }

        return ans;
    }
}