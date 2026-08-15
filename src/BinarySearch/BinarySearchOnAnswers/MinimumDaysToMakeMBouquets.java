package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

// Pattern : Binary search on Answers
public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of flowers: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter blooming days:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter number of bouquets: ");
        int bq = sc.nextInt();

        System.out.print("Enter flowers required per bouquet: ");
        int flowers = sc.nextInt();

        System.out.println("Minimum number of days: " + noOfDays(array, bq, flowers));

        sc.close();
    }

    // TC : O(N × log(maxDay))
    // SC : O(1)
    public static int noOfDays(int[] array, int bq, int flowers) {

        // Agar available flowers required flowers se kam hain toh bouquets possible nahi hain.
        if (array.length < (long) bq * flowers) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;

        // Maximum blooming day find kar rahe hain jo maximum possible answer hoga.
        for (int j : array) {
            largest = Math.max(j, largest);
        }

        int left = 1;
        int right = largest;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int tBq = 0;
            int count = 0;

            // Current day nikalne ke baad dekhengeki us din tak kitne flowers bloom huye and kitne buke bna skte hain
            for (int i = 0; i < array.length; i++) {

                // Agar flower current day tak bloom ho gaya hai toh count increase karo.
                if (array[i] <= mid) {
                    count++;
                } else {
                    // Agar bloom hone jaha pe brk hua toh piche jitne bloom huye utne me se dekho ki kya koi buke ban skta hai ya nhi
                    tBq += count / flowers;
                    // agar flower given day pe bloom nhi hua hai means count wapas 0 se kr do bcz we want continous
                    count = 0;
                }
            }

            // Last consecutive flowers se banne wale bouquets bhi add krna hai
            tBq += count / flowers;

            // Agar exactly required bouquets mil gaye toh current day answer hai.
            if (tBq == bq) {
                return mid;
            }

            // Agar required se zyada bouquets ban rahe hain toh aur minimum day check karo.
            else if (tBq > bq) {
                right = mid - 1;
            }

            // Agar required bouquets nahi ban rahe toh days increase karo.
            else {
                left = mid + 1;
            }
        }

        // Left minimum possible day ko represent karega.
        return left;
    }
}