package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class PrintCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String str  = sc.nextLine();

        printChars(str, 0);
        sc.close();
    }

    public static void printChars(String str, int i) {
        if(i == str.length()) return;
        System.out.println(str.charAt(i++));
        printChars(str, i);
    }
}
