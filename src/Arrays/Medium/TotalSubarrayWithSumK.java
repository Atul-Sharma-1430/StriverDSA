package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TotalSubarrayWithSumK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Brute Force Answer : " + totalSubarraysBrute(array, k));
        System.out.println("Optimal Answer     : " + totalSubarraysOptimal(array, k));

        sc.close();
    }

    // TC : O(n²)
    // SC : O(1)
    public static int totalSubarraysBrute(int[] array, int k) {
        int count = 0;

        // Har index ko starting point maan ke subarrays bnao
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            // i se start hone wale saare subarrays check kro
            for (int j = i; j < array.length; j++) {

                // Current subarray ka sum calculate kro
                sum += array[j];

                // Agar sum k ke equal hai to count increase kr do
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // TC : O(n)
    // SC : O(n)
    public static int totalSubarraysOptimal(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Starting me prefix sum 0 ek baar aaya hua maan lo
        map.put(0, 1);

        for (int i = 0; i < array.length; i++) {

            // Current prefix sum calculate kro
            prefixSum += array[i];

            // Aisa previous prefix sum find kro jisse subarray ka sum k ban jaye
            int rem = prefixSum - k;

            // Agar wo prefix sum pehle mil chuka hai
            if (map.containsKey(rem)) {

                // Jitni baar mila hai utne subarrays mil gye
                count += map.get(rem);
            }

            // Current prefix sum ki frequency update kro
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}