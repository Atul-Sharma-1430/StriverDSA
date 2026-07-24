package Collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        // Min Heap (Default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Max Heap
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        // TC: O(log n) - Adds element to the priority queue
        pq.offer(5);

        // TC: O(log n) - Adds element to the priority queue
        pq.offer(2);

        // TC: O(log n) - Adds element to the priority queue
        pq.offer(10);

        // TC: O(1) - Returns the highest priority element without removing it
        // (Smallest element in Min Heap)
        pq.peek();

        // TC: O(log n) - Removes and returns the highest priority element
        pq.poll();

        // TC: O(n) - Checks if the element exists
        pq.contains(5);

        // TC: O(1) - Returns the number of elements
        pq.size();

        // TC: O(1) - Returns true if the queue is empty
        pq.isEmpty();

        // TC: O(n) - Removes all elements
        pq.clear();
    }
}