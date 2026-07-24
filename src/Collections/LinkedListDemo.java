package Collections;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        // TC: O(1)
        list.add(10);

        // TC: O(1)
        list.addFirst(5);

        // TC: O(1)
        list.addLast(20);

        // TC: O(1)
        list.getFirst();

        // TC: O(1)
        list.getLast();

        // TC: O(n)
        list.get(2);

        // TC: O(1)
        list.remove();

        // TC: O(1)
        list.removeFirst();

        // TC: O(1)
        list.removeLast();

        // TC: O(n)
        list.remove(2);

        // TC: O(1)
        list.peek();

        // TC: O(1)
        list.peekFirst();

        // TC: O(1)
        list.peekLast();

        // TC: O(1)
        list.poll();

        // TC: O(1)
        list.pollFirst();

        // TC: O(1)
        list.pollLast();
    }
}