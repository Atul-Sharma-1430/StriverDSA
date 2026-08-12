package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class KoKoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];

        System.out.println("Enter piles:");
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter number of hours: ");
        int h = sc.nextInt();

        KoKoEatingBananas obj = new KoKoEatingBananas();

        int result = obj.minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed = " + result);

        sc.close();
    }

    public static int largest(int[] piles) {
        int largest = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > largest) {
                largest = pile;
            }
        }

        return largest;
    }

    public int minEatingSpeed(int[] piles, int h) {

        // Binary search ki range 1 se maximum tak hoga kyuki minimum speed 1 aur maximum speed max value hi ho skti hai
        int left = 1;
        // Sabse badi pile nikal rahe hain kyuki Koko ki maximum possible speed maximum pile ke equal ho sakti hai, usse jyada bhi ho skta hai but usse jyda leke kuch fayda nhi hours utne hi lagenge jitna max pe lagega toh isliye array ka max value hi lo taaki binary search me time kam lage

        int right = largest(piles);

        while (left <= right) {

            // Mid ko current eating speed maan kar check karenge ki Koko h hours ke andar saari bananas kha sakta hai ya nahi.
            int mid = left + (right - left) / 2;

            // har selected speed pe kitna hrs lag rha hai total vo store krega
            long temp = 0;
            for (int i = 0; i < piles.length; i++) {
                // Ceiling division use kar rahe hain taaki aadhi pile ke liye bhi poora 1 hour count ho aisa condition hai
                temp += (piles[i] + mid - 1) / mid;
            }

            // Agar required hours h se kam ya equal hain toh current speed valid hai, isliye aur chhoti speed search karenge.
            if (temp <= h) {
                right = mid - 1;
            } else {
                // Agar required hours h se zyada hain toh current speed slow hai, isliye speed badhani padegi.
                left = mid + 1;
            }
        }

        // Loop ke end mein left minimum valid eating speed par point karega, isliye wahi answer return karenge.
        return left;
    }
}