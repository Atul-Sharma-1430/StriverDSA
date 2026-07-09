package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int num = sc.nextInt();

        System.out.println(sumTheDigits(num , 0));
        sc.close();
    }

    public static int sumTheDigits(int num, int sum) {
        if(num == 0 ) return sum;
        int lst = num % 10;
        num /=10;
        return sumTheDigits(num, sum+lst);
    }

}
