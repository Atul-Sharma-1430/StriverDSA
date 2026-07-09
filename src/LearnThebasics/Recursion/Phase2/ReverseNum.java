package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(reverseTheNum(num, 0));
        sc.close();
    }

    public static int reverseTheNum(int num, int rev) {
        if(num == 0) return rev;
        int last = num % 10;
        num /= 10;
        return reverseTheNum(num , (rev * 10 + last));
    }
}
