package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        System.out.println(printFact(sc.nextInt()));
        sc.close();
    }
    public static long printFact(int num) {
        if( num == 1) return 1;
        return num * printFact(--num);
    }
}
