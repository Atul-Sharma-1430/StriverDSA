package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class PrimeChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number which is to be checked for prime: ");
        int num = sc.nextInt();

        if (checkPrime(num , 2)) {
            System.out.println(num + " is a prime number");
        } else {
            System.out.println(num + " is not a prime number");
        }

        sc.close();
    }

    public static boolean checkPrime(int num, int i) {
        if(num < 2) return false;
        if(i > Math.sqrt(num)) return true;
        if(num % i == 0)  return false;
        return checkPrime(num , ++i);
    }
}
