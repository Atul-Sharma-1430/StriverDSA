package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// Pattern : Binary search on answers ====> (min) max OR (max) min
// In this pattern is min of max
// This q has similar solution as shipWithMaxCapacity wla problem

public class BookAllocationProblem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter pages in each book:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        System.out.println("Minimum possible maximum pages = " + minOfMaxPages(nums, students));

        sc.close();
    }

    public static boolean isPossible(int[] nums, int students, int pages) {
        // Pehle student ko books dena start kar rahe hain
        int count = 1;

        // Current student ko mile total pages
        int totalPages = 0;

        for (int i = 0; i < nums.length; i++) {

            // Agar mere current page and already given page to single student is more than max which we have selected then allocate it to student means count++
            if (totalPages + nums[i] > pages) {
                // Naye student ko current book allocate karenge
                count++;
                // Naye student ke pages current book se start honge
                totalPages = nums[i];

            } else {

                // Agar mere current page and already given page to single student is less than max which we have selected toh same student ko aur pages do
                totalPages += nums[i];
            }
        }

        // Required students ke andar allocation possible hai
        return count <= students;
    }

    // TC : O(n log(sum - max))
    // SC : O(1)
    public static int minOfMaxPages(int[] nums, int students) {

        // Agar students books se zyada hain toh
        // har student ko at least ek book dena possible nahi hai
        if (students > nums.length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Maximum single book ke pages find kar rahe hain
            max = Math.max(nums[i], max);
            // Saari books ke pages ka sum
            sum += nums[i];
        }

        // Minimum possible answer means start wale student ko maximum page ko kyuki humko min of max chahiye
        int left = max;
        // Maximum possible answer means sab pages ek hi student ko de do
        int right = sum;
        int ans = -1;

        while (left <= right) {
            int pages = left + (right - left) / 2;

            boolean possible = isPossible(nums, students, pages);

            if (possible) {
                // agar current no. of pages de rhe hain and sabhi student me  properly allocate ho jaa rha hai toh hum aur chhota possible answer dhudenge kyuki humko minimum if maximum chahiye
                ans = pages;
                right = pages - 1;

            } else {
                // Current pages limit possible nahi hai toh pages limit badhani padegi
                left = pages + 1;
            }
        }

        return ans;
    }
}

// 1. Answer ka search space/range dhundo
//          ↓
// 2. Mid mein ek possible answer choose karo
//          ↓
// 3. Check karo: "Kya ye answer possible hai?"
//          ↓
// 4. Possible / Not Possible ke basis par pointer move karo