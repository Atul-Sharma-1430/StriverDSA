package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class NumWithoutParam {
    static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms you want to print:");
        num = sc.nextInt();
        printNum();
        sc.close();
    }

    public static void printNum() {
        if(num == 0) return ;
        --num;
        printNum();
        System.out.println(++num);
    }
}
