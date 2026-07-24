package Collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        // TC: O(1) Average - Adds an element (duplicates are ignored)
        set.add(10);

        // TC: O(1) Average - Adds another element
        set.add(20);

        // TC: O(1) Average - Removes the specified element
        set.remove(10);

        // TC: O(1) Average - Checks if the element exists
        set.contains(10);

        // TC: O(1) - Returns the number of elements
        set.size();

        // TC: O(1) - Returns true if the set is empty
        set.isEmpty();

        // TC: O(n) - Removes all elements
        set.clear();

        // TC: O(n) - Traverses all elements
        for (int x : set) {
        }

        // TC: O(n) - Traverses all elements using Iterator
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}