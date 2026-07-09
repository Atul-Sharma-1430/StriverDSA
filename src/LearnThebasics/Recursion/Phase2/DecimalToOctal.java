package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("Octal: 0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        convertToOctal(num, sb);

        System.out.println(num + " in octal will be " + sb.reverse());

        sc.close();
    }

    public static void convertToOctal(int num, StringBuilder sb) {
        if(num == 0) return;
        int rem = num % 8;
        sb.append(rem);
        num /= 8;
        convertToOctal(num, sb);
    }
}
