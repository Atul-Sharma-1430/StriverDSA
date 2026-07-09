package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class PrimeDigitsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int num = sc.nextInt();

        System.out.println(num + " has " + countPrimeDigits(num) + " prime digits.");
        sc.close();
    }

    public static boolean checkPrime(int num, int i) {
        if(num < 2) return false;
        if(i > Math.sqrt(num)) return true;
        if(num % i == 0)  return false;
        return checkPrime(num , ++i);
    }

    public static int countPrimeDigits(int num) {
        if(num == 0) return 0;
        int last = num % 10;
        int count = checkPrime(last , 2) ? 1 : 0;
        return count + countPrimeDigits(num /10);
    }
}
