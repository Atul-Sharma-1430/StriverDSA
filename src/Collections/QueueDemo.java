package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // TC: O(1) - Adds element to the rear of the queue
        q.offer(10);

        // TC: O(1) - Adds element to the rear of the queue
        q.offer(20);

        // TC: O(1) - Removes and returns the front element
        q.poll();

        // TC: O(1) - Returns the front element without removing it
        q.peek();

        // TC: O(1) - Returns the number of elements in the queue
        q.size();

        // TC: O(1) - Returns true if the queue is empty
        q.isEmpty();

        // TC: O(n) - Removes all elements from the queue
        q.clear();
    }
}