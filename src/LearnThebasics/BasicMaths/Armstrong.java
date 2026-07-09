package LearnThebasics.BasicMaths;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number Which is to be Checked: ");
        int num = sc.nextInt();

        if (num < 9) {
            System.out.println("Please Enter at least 2 Digit Number");
            return;
        }

        if(isArmstrong(num) == num) {
            System.out.println(num + " is an Armstrong Number.");
        } else {
            System.out.println(num + " is not an Armstrong Number.");
        }

        sc.close();

    }

    public static int isArmstrong(int num) {
        int digits = noOfDigits(num);

        int sum = 0;

        while (num != 0) {
            int last = num % 10;
            sum += (int) Math.pow(last , digits);
            num /= 10;
        }


        return sum;
    }

    public static int noOfDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
