package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int num2 = sc.nextInt();

        System.out.println("GCD of " + num1 + " and " + num2 + " is " + findGCD(num1, num2));

        sc.close();

    }

    public static int findGCD(int num1, int num2) {
        int gcd = 0;

        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
