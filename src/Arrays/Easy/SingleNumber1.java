package Arrays.Easy;

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

    // TC : O(2n+k)
    // SC : O(k)
    public static int findSingleNumber2(int [] array) {
        int largest = 0;
        for (int j : array) {
            if (j > largest) largest = j;
        }


        int[] hashArray = new int[largest+1];
        for (int j : array) {
            hashArray[j]++;
        }


        for (int i = 0; i < hashArray.length; i++) {
            if(hashArray[i] == 1)  {
                return i;
            }
        }

        return -1;
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

        int result = findSingleNumber2(nums);

        System.out.println("Single Number: " + result);

        sc.close();
    }
}
