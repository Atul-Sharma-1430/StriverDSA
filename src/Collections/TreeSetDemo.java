package Collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        // Stores only unique elements (No duplicates)
        // Stores elements in sorted (ascending) order by default
        TreeSet<Integer> set = new TreeSet<>();

        // TC: O(log n) - Adds an element in sorted order
        set.add(10);

        // TC: O(log n) - Removes the specified element
        set.remove(10);

        // TC: O(log n) - Checks if the element exists
        set.contains(10);

        // TC: O(log n) - Returns the smallest element
        set.first();

        // TC: O(log n) - Returns the largest element
        set.last();

        // TC: O(log n) - Returns the smallest element >= given value
        set.ceiling(15);

        // TC: O(log n) - Returns the largest element <= given value
        set.floor(15);

        // TC: O(log n) - Returns the smallest element > given value
        set.higher(15);

        // TC: O(log n) - Returns the largest element < given value
        set.lower(15);

        // TC: O(log n) - Removes and returns the first (smallest) element
        set.pollFirst();

        // TC: O(log n) - Removes and returns the last (largest) element
        set.pollLast();

        // TC: O(n) - Traverses all elements in sorted order
        for (int x : set) {
        }

        // TC: O(n) - Traverses all elements using Iterator
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            it.next();
        }

        // TC: O(1) - Returns the number of elements
        set.size();

        // TC: O(1) - Returns true if the set is empty
        set.isEmpty();

        // TC: O(n) - Removes all elements
        set.clear();
    }
}