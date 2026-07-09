package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class OddNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms you want to print:");
        printNum(sc.nextInt());
        sc.close();
    }

    public static void printNum(int num) {
        if(num == 1) return;
        printNum(--num);
        if(num %2 != 0) {
            System.out.println(num);
        }

    }
}
