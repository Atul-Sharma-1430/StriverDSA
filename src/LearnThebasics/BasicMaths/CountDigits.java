package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if(number < 0) {
            System.out.println("Enter a Positive Number");
            return;
        }

        int result = countDigit(number);

        System.out.println("Number of digits: " + result);

        sc.close();
    }

    public static int countDigit(int n) {
        int count = 0;

        if (n < 10) {
            return 1;
        }

        while (n != 0) {
            count++;
            n /= 10;
        }

        return count;
    }
}
