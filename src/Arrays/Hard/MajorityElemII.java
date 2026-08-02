package Arrays.Hard;

import java.util.*;

class MajorityElemII {
    // TC: O(n)
    // SC: O(n)
    public static List<Integer> majorityElementBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of each element
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        // Find elements having frequency > n/3
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static List<Integer> majorityElementOptimal(int[] nums) {

        // Candidate 1 store krega
        int candidate1 = Integer.MIN_VALUE;
        int count1 = 0;

        // Candidate 2 store krega
        int candidate2 = Integer.MIN_VALUE;
        int count2 = 0;

        // Ye loop 2 possible majority candidates find krega
        for (int num : nums) {

            // Agar candidate1 ki votes khatam ho gayi aur current number candidate2 nahi hai,
            // to current number ko candidate1 bana do.
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            }
            // Agar candidate2 ki votes khatam ho gayi aur current number candidate1 nahi hai,
            // to current number ko candidate2 bana do.
            else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            }
            // Current number candidate1 ke equal hai to uski vote badha do.
            else if (num == candidate1) {
                count1++;
            }
            // Current number candidate2 ke equal hai to uski vote badha do.
            else if (num == candidate2) {
                count2++;
            }
            // Agar current number dono candidates se different hai,
            // to dono ki ek-ek vote cancel ho jayegi.
            else {
                count1--;
                count2--;
            }
        }

        // Upper loop sirf possible candidates deta hai.
        // Ye guarantee nahi hoti ki ye answer hi honge.
        // Isliye actual frequency dobara count karni padegi.
        count1 = 0;
        count2 = 0;

        // Dono candidates ki actual frequency count kro.
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Agar candidate1 ki frequency n/3 se jyada hai to answer me add kro.
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        // Agar candidate2 ki frequency n/3 se jyada hai to answer me add kro.
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> result = majorityElementBetter(nums);
        List<Integer> result2 = majorityElementOptimal(nums);

        System.out.println("Majority Elements: " + result);
        System.out.println("Majority Elements: " + result2);

        sc.close();
    }
}