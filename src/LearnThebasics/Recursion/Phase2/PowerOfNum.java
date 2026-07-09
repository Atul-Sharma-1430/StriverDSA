package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class PowerOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        System.out.print("Enter the power: ");
        int pow = sc.nextInt();
        System.out.println(calPow(num , pow));
        sc.close();
    }

    public static long calPow(int num, int pow) {
        if(pow == 1) return num;
        return num * calPow(num , --pow);
    }
}
