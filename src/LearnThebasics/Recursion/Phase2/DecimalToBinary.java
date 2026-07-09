package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("Binary: 0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        convertToBin(num, sb);

        System.out.println(sb.reverse());

        sc.close();
    }

    public static void convertToBin(int num, StringBuilder sb) {
        if (num == 0) return;

        sb.append(num%2);
        convertToBin(num/2, sb);
    }
}