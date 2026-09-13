package LinkedList.LearnDoublyLL;

public class Node {
    Node prev;
    int data;
    Node next;

    public Node(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.prev = null;
        this.data = data;
        this.next = next;
    }

    public Node(Node prev, int data) {
        this.prev = prev;
        this.data = data;
        this.next = null;
    }

    public Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
