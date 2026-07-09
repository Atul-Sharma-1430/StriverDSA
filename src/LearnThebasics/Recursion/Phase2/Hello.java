package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        System.out.print("Enter how many Hello's you want to print:");
        printHello(sc.nextInt());
        sc.close();
    }

    public static void printHello(int n) {
        if(n == 0) {
            return;
        }
        System.out.println("Hello " + n);
        printHello(--n);
    }
}
