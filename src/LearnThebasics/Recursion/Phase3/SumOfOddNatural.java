package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class SumOfOddNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms you want the sum up to:");
        int num = sc.nextInt();

        System.out.println(printOddSum1((num * 2) - 1, 0));
        System.out.println(printOddSum2(num));

        sc.close();
    }

    // Method 1
    public static int printOddSum1(int num, int sum) {
        if(num == 1) return sum;
        sum += num;
        num -= 2;
        return printOddSum1(num , sum);
    }

    // Method 2
    public static int printOddSum2(int num) {
        if(num == 1) return 1;
        return ((num * 2) - 1) + printOddSum2(num - 1);

    }
}
