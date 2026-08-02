package Arrays.Hard;

import java.util.*;

public class ThreeSum {

    // TC : O(n^3)
    // SC : O(triplets) -> HashSet + Output
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    // Agar teeno ka sum 0 hai to triplet mil gaya
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        // Triplet ko sort kro taki duplicates remove ho sake
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(triplet);

                        set.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // TC : O(n^2)
    // SC : O(n) + O(triplets)
    public static List<List<Integer>> threeSumBetter(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Current i ke liye visited elements store krenge
            Set<Integer> thirdValue = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {

                // get value of third element
                int third = -(nums[i] + nums[j]);

                // Agar required third element pehle mil chuka hai
                if (thirdValue.contains(third)) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    Collections.sort(triplet);
                    set.add(triplet);
                }

                // Current element ko jab tak j lasst tak na pahuche tab tk  ke liye store kr do
                thirdValue.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }

    // TC : O(n^2)
    // SC : O(1)
    public static List<List<Integer>> threeSumOptimal(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // Two Pointer use krne ke liye array sort kro
        Arrays.sort(nums);

        int i = 0;
        // Last 2 elements se triplet nahi ban sakta
        while (i < nums.length - 2) {

            int first = nums[i];
            // Agar first element hi positive hai to aage sum 0 kabhi nahi banega kyuki sorted hain toh aage sab values badhi hi hongi
            if (first > 0) {
                break;
            }

            // Duplicate first element skip kro
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            // Two Sum login
            while (j < k) {

                int sum = first + nums[j] + nums[k];
                // Sum bada hai to right pointer piche lao
                if (sum > 0) {
                    k--;
                }
                // Sum chhota hai to left pointer aage badhao
                else if (sum < 0) {
                    j++;
                }

                // if 0
                else {
                    ans.add(Arrays.asList(first, nums[j], nums[k]));

                    // Left side ke duplicates skip kro
                    while (j + 1 < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Right side ke duplicates skip kro
                    while (k - 1 > j && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Next unique pair check kro
                    j++;
                    k--;
                }
            }

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("\nBrute Force:");
        System.out.println(threeSumBrute(nums.clone()));

        System.out.println("\nBetter:");
        System.out.println(threeSumBetter(nums.clone()));

        System.out.println("\nOptimal:");
        System.out.println(threeSumOptimal(nums.clone()));

        sc.close();
    }
}
