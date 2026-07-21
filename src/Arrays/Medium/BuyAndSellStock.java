package Arrays.Medium;

import java.util.Scanner;

public class BuyAndSellStock {
    // TC: O(n)
    // SC: O(1)
    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }

            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);

        sc.close();
    }
}
