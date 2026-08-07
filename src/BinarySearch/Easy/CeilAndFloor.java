package BinarySearch.Easy;

import java.util.Scanner;

/*
    Lower Bound  -> >=   (Index)
    Upper Bound  -> >    (Index)

    Ceil         -> >=   (Element)
    Floor        -> <=   (Element)
*/

public class CeilAndFloor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Ceil: " + ceil(nums, target));
        System.out.println("Floor: " + floor(nums, target));

        sc.close();
    }

    // TC : O(log n)
    // SC : O(1)
    //
    // Ceil = Smallest element >= target
    public static int ceil(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ceil = -1; // agar ceil exist nahi karta

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ceil = nums[mid];
                break;
            } else if (nums[mid] > target) {
                ceil = nums[mid]; // possible answer
                right = mid - 1;  // aur chhota ceil dhoondo jo current ceil se chhota ho but target se bda
            } else {
                left = mid + 1;
            }
        }

        return ceil;
    }


    // TC : O(log n)
    // SC : O(1)
    //
    // Floor = Largest element <= target
    public static int floor(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int floor = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                floor = nums[mid];
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;  // chhota element dhoondo
            } else {
                floor = nums[mid]; // possible answer
                left = mid + 1;    // bada floor dhoondo jo current floor se bda ho but target se chhota
            }
        }

        return floor;
    }
}
