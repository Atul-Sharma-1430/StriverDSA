package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        // ---------------- Iterator ----------------

        // TC: O(1) - Returns an Iterator for the list
        Iterator<Integer> it = list.iterator();

        // TC: O(n) - Traverses all elements
        while (it.hasNext()) {

            // TC: O(1) - Returns the next element
            System.out.println(it.next());
        }

        // ---------------- ListIterator ----------------

        // TC: O(1) - Returns a ListIterator for the list
        ListIterator<Integer> lit = list.listIterator();

        // TC: O(1) - Returns the next element
        lit.next();

        // TC: O(1) - Returns the previous element
        lit.previous();

        // TC: O(1) - Checks if a next element exists
        lit.hasNext();

        // TC: O(1) - Checks if a previous element exists
        lit.hasPrevious();

        // TC: O(1) - Replaces the last returned element
        lit.set(100);

        // TC: O(1) - Inserts an element at the current position
        lit.add(50);

        // TC: O(1) - Removes the last returned element
        lit.remove();
    }
}