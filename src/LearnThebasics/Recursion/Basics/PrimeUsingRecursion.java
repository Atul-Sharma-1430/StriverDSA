package LearnThebasics.Recursion.Basics;

import java.util.Scanner;

public class PrimeUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        PrimeUsingRecursion pur = new PrimeUsingRecursion();

        if (num == 1) {
            System.out.println("1 is neither prime nor composite");
        } else if (num < 1) {
            System.out.println("Please enter a valid positive number.");
        } else {
            boolean result = pur.isPrime(2, num);
            if (result) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }

        sc.close();
    }

    boolean isPrime(int divisor, int num) {

        if (divisor > Math.sqrt(num)) return true;
        if (num % divisor == 0) return false;

        return isPrime(divisor + 1, num);
    }
}
