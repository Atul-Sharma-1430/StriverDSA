package Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        // TC: O(1) - Adds element at the front
        dq.offerFirst(10);

        // TC: O(1) - Returns the front element without removing it
        dq.peekFirst();

        // TC: O(1) - Removes and returns the front element
        dq.pollFirst();

        // TC: O(1) - Adds element at the rear
        dq.offerLast(20);

        // TC: O(1) - Returns the last element without removing it
        dq.peekLast();

        // TC: O(1) - Removes and returns the last element
        dq.pollLast();

        // TC: O(1) - Pushes element onto the front (Stack operation)
        dq.push(5);

        // TC: O(1) - Removes and returns the front element (Stack pop)
        dq.pop();

        // TC: O(1) - Returns the front element without removing it (Stack peek)
        dq.peek();
    }
}