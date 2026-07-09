package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class nCr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        long n = sc.nextLong();

        System.out.print("Enter r: ");
        long r = sc.nextLong();

        if (r > n) {
            System.out.println("r(" + r + ") cannot be greater than n(" + n + ")");
            return;
        } else if (r == 0 || r == n) {
            System.out.println("nCr = 1");
            return;
        } else if (r == 1) {
            System.out.println("nCr = " + n);
            return;
        } else {
            System.out.println(printFact(n) / (printFact(n - r) * printFact(r)));
        }

        sc.close();
    }

    public static long printFact(long num) {
        if( num <= 1) return 1;
        return num * printFact(num - 1);
    }
}
