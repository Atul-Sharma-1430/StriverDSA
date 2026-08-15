package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// Pattern : Binary search on Answers
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter package weights:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        System.out.println("Minimum ship capacity: " + minDays(nums, days));

        sc.close();
    }


    // Given capacity ke liye kitne days lagenge ye calculate karta hai
    // TC: O(N)
    // SC: O(1)
    public static int isMinCap(int[] nums, int mid) {

        int capacity = 0;
        int days = 1;

        for (int i = 0; i < nums.length; i++) {

            // Agar current package add karne par capacity exceed ho jaaye
            if (capacity + nums[i] > mid) {
                capacity = nums[i]; // and current value ko next days ke liye load kr do kyuki usi ke wajh se exceed ho rha hai toh usko next day me bhej do
                days++; // days increase kr do

            } else {
                //jab tk kam hai tab tak Same day mein hi package load karo
                capacity += nums[i];
            }
        }

        return days;
    }

    // TC: O(N * log(sum - max))
    // SC: O(1)
    public static int minDays(int[] nums, int days) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Minimum possible capacity = maximum weight
        // Maximum possible capacity = total sum
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        int left = max;
        int right = sum;

        int ans = 0; // stores final ans
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // mid jo nikale us capacity se kitna din lagega vo nikalo
            int day = isMinCap(nums, mid);

            // Agar required days ke andar ship kar sakte hain
            if (day <= days) {
                ans = mid;
                // Aur smaller capacity try karo
                right = mid - 1;
            } else {
                // agar choosen capacity se jo days mil rhe hain vo jyada hai means capacity badhai padegi per day ki
                left = mid + 1;
            }
        }

        return ans;
    }
}