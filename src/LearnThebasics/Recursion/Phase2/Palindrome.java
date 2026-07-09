package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        if(isPalindrome(Math.abs(num) , 0) == num) {
            System.out.println(num + " is palindrome");
        } else {
            System.out.println(num + " is not palindrome");
        }
        sc.close();
    }

    public static int isPalindrome(int num, int rev) {
        if(num == 0) return rev;
        int last = num % 10;
        num /= 10;
        return isPalindrome(num , (rev * 10 + last));
    }
}
