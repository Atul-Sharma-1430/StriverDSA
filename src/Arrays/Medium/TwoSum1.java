package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the Target value: ");
        int target  = sc.nextInt();

        System.out.println((Arrays.toString(twoSumOptimal(array, target))));
    }

    // TC : O(n2)
    // SC : O(1)
    public static int[] brute(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i] + array[j] == target) {
                    return new int[] {i , j};
                }
            }
        }

        return new int[] {-1, -1};
    }


    // TC : O(n)
    // SC : O(n)
    public static int[] twoSumOptimal(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<array.length; i++) {
            int rem = target - array[i];

            // if the map has already that remaining value means we got the pair so return it
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                return new int[] {j,i};
            }

            // else store tne value in map
            map.put(array[i], i);
        }

        return new int[] {-1, -1};
    }
}
