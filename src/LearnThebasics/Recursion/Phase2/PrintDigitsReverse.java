package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class PrintDigitsReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        printDigits(num);
        sc.close();
    }

    public static void printDigits(int num) {
        if(num == 0) return;
        System.out.print(num%10 + " ");
        printDigits(num/10);
    }
}
