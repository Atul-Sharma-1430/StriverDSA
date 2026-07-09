package LearnThebasics.Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintSubsequences {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        int size = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers.add(sc.nextInt());
        }

        List<List<Integer>> result = new ArrayList<>();

        PrintSubsequences ps = new PrintSubsequences();
        ps.printSubsequences(0 , numbers , new ArrayList<>(), result);

        for (List<Integer> seq : result) {
            System.out.println(seq);
        }

        sc.close();
    }

    void printSubsequences(int index, List<Integer> numbers, List<Integer> current, List<List<Integer>> result) {

        if (index == numbers.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(numbers.get(index));
        printSubsequences(index + 1, numbers, current, result);

        current.removeLast();
        printSubsequences(index + 1, numbers, current, result);

    }
}
/*Start:
eg : [1,2] is the input array

current = [] → ye ek temporary list hai jo subsequence ko step-by-step banati hai. Jab tak base case (index == numbers.size()) pe nahi
               pahuchte,recursion har step me ek element add karega aur fir usi ko explore karega. Agar include nahi karna hua to remove
               karke dusra path explore karega.

result = [] → ye ek permanent storehouse hai. Jab recursion base case tak pahuchta hai, tab us time jo bhi current me subsequence bana
              hua hai, uska ek copy result me store kar dete hain.

Take 1:
current = [1]
Explore further…

Take 2:
current = [1,2]
Add to result → [[1,2]]

Backtrack (remove 2):
current = [1]
Add to result → [[1,2], [1]]

Backtrack (remove 1):
current = []

Take 2:
current = [2]
Add to result → [[1,2], [1], [2]]

Backtrack again:
current = []
Add empty subsequence → result = [[1,2], [1], [2], []]
*/
