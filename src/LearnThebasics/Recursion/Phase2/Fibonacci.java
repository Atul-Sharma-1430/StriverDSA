package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms you want to print:");
        int terms = sc.nextInt();
        for (int i = 0; i < terms; i++) {
            System.out.println(printFib(i)+ " ");
        }
        sc.close();
    }

    public static int printFib(int terms) {
        if (terms == 0) return 0;
        else if (terms == 1) return 1;
        else return printFib(terms - 1) + printFib(terms - 2);
    }
}
