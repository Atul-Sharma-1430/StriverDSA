package Collections;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // TC: O(1) (Amortized)
        list.add(10);

        // TC: O(n)
        list.add(1, 20);

        // TC: O(1)
        list.get(0);

        // TC: O(1)
        list.set(0, 100);

        // TC: O(n)
        list.remove(0);

        // TC: O(n)
        list.remove(Integer.valueOf(100));

        // TC: O(n)
        list.contains(10);

        // TC: O(n)
        list.indexOf(10);

        // TC: O(n)
        list.lastIndexOf(10);

        // TC: O(1)
        list.size();

        // TC: O(1)
        list.isEmpty();

        // TC: O(n)
        list.clear();

        // TC: O(n)
        for (int x : list) {
        }

        // TC: O(n)
        for (int i = 0; i < list.size(); i++) {
        }

        // TC: O(n)
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }

        // TC: O(n log n)
        Collections.sort(list);

        // TC: O(n)
        Collections.reverse(list);

        // TC: O(n)
        Collections.shuffle(list);

        // TC: O(n)
        Collections.max(list);

        // TC: O(n)
        Collections.min(list);

        // TC: O(n)
        Collections.frequency(list, 10);
    }
}