package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // - Stores data as Key-Value pairs
        // - Keys are unique, Values can be duplicate
        // - Stores keys in sorted (ascending) order
        // - Implemented using Red-Black Tree (Self-Balancing BST)
        // - Null keys are NOT allowed, Null values are allowed
        // - Put/Get/Remove/Search -> O(log n)
        TreeMap<Integer, String> map = new TreeMap<>();

        // TC: O(log n) - Adds or updates a key-value pair
        map.put(1, "A");

        // TC: O(log n) - Returns the value for the given key
        map.get(1);

        // TC: O(log n) - Returns the smallest key
        map.firstKey();

        // TC: O(log n) - Returns the largest key
        map.lastKey();

        // TC: O(log n) - Returns the smallest key >= given key
        map.ceilingKey(5);

        // TC: O(log n) - Returns the largest key <= given key
        map.floorKey(5);

        // TC: O(log n) - Returns the smallest key > given key
        map.higherKey(5);

        // TC: O(log n) - Returns the largest key < given key
        map.lowerKey(5);

        // TC: O(log n) - Removes and returns the first key-value pair
        map.pollFirstEntry();

        // TC: O(log n) - Removes and returns the last key-value pair
        map.pollLastEntry();

        // TC: O(1) - Returns the number of key-value pairs
        map.size();

        // TC: O(1) - Returns true if the map is empty
        map.isEmpty();

        // TC: O(n) - Removes all key-value pairs
        map.clear();

        // TC: O(n) - Traverses all key-value pairs in sorted order
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}