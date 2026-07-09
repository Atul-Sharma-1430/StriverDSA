package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class SumOfNaturalNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms you want the sum up to:");
        System.out.println(printSum(sc.nextInt()));
        sc.close();
    }

    public static int printSum(int num) {
        if(num == 1) return 1;
        return num + printSum(--num);
    }
}
