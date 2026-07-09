package LearnThebasics.Recursion.Phase2;

import java.util.Scanner;

public class CountZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(countZeros(num , 0));
        sc.close();
    }

    public static int countZeros(int num, int count) {
        if(num == 0) return count;
        if(num % 10 == 0) count ++;
        return countZeros(num/10, count);
    }
}
