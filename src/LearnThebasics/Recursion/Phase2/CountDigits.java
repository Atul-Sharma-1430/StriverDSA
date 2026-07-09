package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(countDigit(Math.abs(num), 1));
        sc.close();
    }

    static public int countDigit(int num, int count) {
        if(num < 10) return count;
        count++;
        num /= 10;
        return countDigit(num , count);

    }
}
