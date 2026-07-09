package LearnThebasics.Recursion.Basics;

import java.util.Scanner;

public class NToOneBackTracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the last number: ");
        int num = sc.nextInt();
        printNum(num, 1);
        sc.close();
    }

    static void printNum(int num, int first) {
        if (first > num) {
            return;
        }
        printNum(num, first + 1);
        System.out.println(first);
    }
}
