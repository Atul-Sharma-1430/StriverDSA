package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Stores data as Key-Value pairs
        // Keys are unique, Values can be duplicate
        // No insertion or sorting order is guaranteed
        // Allows one null key and multiple null values
        HashMap<Integer, String> map = new HashMap<>();

        // TC: O(1) Average - Adds or updates a key-value pair
        map.put(1, "A");

        // TC: O(1) Average - Returns the value for the given key
        map.get(1);

        // TC: O(1) Average - Returns value if key exists, otherwise default value
        map.getOrDefault(2, "NA");

        // TC: O(1) Average - Checks if the key exists
        map.containsKey(1);

        // TC: O(n) - Checks if the value exists
        map.containsValue("A");

        // TC: O(1) Average - Removes the key-value pair
        map.remove(1);

        // TC: O(1) Average - Replaces the value for an existing key
        map.replace(1, "B");

        // TC: O(1) Average - Inserts only if the key is absent
        map.putIfAbsent(2, "C");

        // TC: O(1) - Returns the number of key-value pairs
        map.size();

        // TC: O(1) - Returns true if the map is empty
        map.isEmpty();

        // TC: O(n) - Removes all key-value pairs
        map.clear();

        // TC: O(1) - Returns a Set of all keys
        map.keySet();

        // TC: O(1) - Returns a Collection of all values
        map.values();

        // TC: O(1) - Returns a Set of all key-value pairs
        map.entrySet();

        // TC: O(n) - Traverse using entrySet()
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // TC: O(n) - Traverse using keySet()
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}