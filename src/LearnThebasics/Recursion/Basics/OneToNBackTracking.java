package LearnThebasics.Recursion.Basics;

import java.util.Scanner;

public class OneToNBackTracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the last number: ");
        int num = sc.nextInt();
        printNum(num , 1);
        sc.close();
    }

    static int printNum(int num, int first) {
        if (num < first) {
            return 0;
        }
        printNum(num - 1, first);
        System.out.println(num);
        return 0;
    }
}
