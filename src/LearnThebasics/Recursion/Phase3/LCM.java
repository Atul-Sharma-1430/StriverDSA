package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class LCM {
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

        System.out.println(findLCM(num1 , num2, 1));
        sc.close();
    }

    public static int findLCM(int num1 , int num2, int i) {
        if((num2 * i) % num1 == 0) return num2 * i;
        return findLCM(num1, num2, ++i);
    }
}
