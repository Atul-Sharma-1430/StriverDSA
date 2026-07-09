package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class ProdOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int num = sc.nextInt();

        System.out.println(findProd(Math.abs(num) , 1));
        sc.close();
    }

    public static int findProd(int num, int prod) {
        if(num == 0) return prod;
        int last = num % 10;
        return findProd(num/10, prod*last);
    }
}
