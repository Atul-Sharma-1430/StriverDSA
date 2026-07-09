package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class LcmAfterGcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        if(num1 > num2) {

        } else {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.println(LCM(num1 , num2));
        sc.close();
    }

    private static int GCD(int num1 , int num2) {
        if (num1 % num2 == 0) return num2;
        int temp = num1;
        num1 = num2;
        num2  = temp % num2;
        return GCD(num1, num2);
    }

    public static int LCM(int num1 , int num2) {
        return num1 * num2 / GCD(num1,num2);
    }
}
