package LinkedList.Learn1DLL;

// Linked List Template
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntroToLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        Node x = new Node(arr[0]);
        System.out.println(x.data); // 1
    }
}
