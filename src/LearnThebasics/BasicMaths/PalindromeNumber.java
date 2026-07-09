package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (num < 9) {
            System.out.println("Please Enter at least 2 Digit Number");
            return;
        }

        if (isPalindrome(num)) {
            System.out.println(num + " is Palindrome");
        } else {
            System.out.println(num + " is not palindrome");
        }

        sc.close();
    }

    public static Boolean isPalindrome(int num) {
        int rev = 0;
        int cpy = num;
        while(num !=0) {
            int last = num % 10;
            num /= 10;
            rev = (rev * 10) + last;
        }
        return rev == cpy;
    }
}
