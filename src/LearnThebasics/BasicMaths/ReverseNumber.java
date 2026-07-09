package LearnThebasics.BasicMaths;
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number: ");
        int num = sc.nextInt();


    }

    public static int reverseTheNum(int num) {
        if(num < 0) {
            return num;
        }

        if(num < 10) {
            return num;
        }

        int rev = 0;
        while(num != 0) {
            int last = num % 10;
            num /= 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && last > 7)) {
                System.out.println("Reversing Will Exceed the Max Value");
                return 0;
            }

            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && last < -8)) {
                System.out.println("Reversing will make the number less than Min value ");
                return 0;
            }
            rev = (rev * 10) + last;
        }

        return rev;
    }
}
