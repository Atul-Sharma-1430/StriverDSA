package LearnThebasics.Recursion.Phase3;

import java.util.Scanner;

public class MaxAndMinDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms you want the sum up to:");
        int num = sc.nextInt();

        System.out.println("Maximum digit in " + num + " is " + maxDigit(num , Integer.MIN_VALUE));
        System.out.println("Minimum digit in " + num + " is " + minDigit(num , Integer.MAX_VALUE));

    }

    public static int maxDigit(int num, int max) {
        if(num <= 0) return max;
        int last = num % 10;
        if(last > max) max = last;
        return maxDigit(num /10, max);
    }

    public static int minDigit(int num, int min) {
        if(num <= 0) return min;
        int last = num % 10;
        if(last < min) min = last;
        return minDigit(num /10, min);
    }
}
