package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class SumOfEvenNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms you want the sum up to:");
        int num = sc.nextInt();

        System.out.println(printEvenSum(num * 2, 0));
        System.out.println(printEvenSum2(num));

        sc.close();
    }

    // Method 1
    public static int printEvenSum(int num, int sum) {
        if(num == 0) return sum;
        sum += num;
        num -= 2;
        return printEvenSum(num , sum);
    }

    // Method 2
    public static int printEvenSum2(int num) {
        if(num == 1) return 2;
        return num * 2 + printEvenSum2(num - 1);

    }
}
