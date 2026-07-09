package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number to check Prime:");
        int num = sc.nextInt();

        if(isPrime1(num) && isPrime2(num)) System.out.println(num + " is a prime number.");
        else System.out.println(num + " is not a prime number.");

        sc.close();
    }

    public static Boolean isPrime1(int num) {
        for (int i = 2; i <= num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static Boolean isPrime2(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if(num % i == 0) count++;
        }
        return count == 2;
    }
}
