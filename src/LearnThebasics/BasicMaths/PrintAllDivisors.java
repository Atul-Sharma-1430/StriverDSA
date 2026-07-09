package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class PrintAllDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number whose divisors are to be printed: ");
        int num = sc.nextInt();

        int i = 1;
        do {
            if(num % i == 0) System.out.print(i + " ");
            i++;
        } while(i<=num);

        sc.close();
    }
}
