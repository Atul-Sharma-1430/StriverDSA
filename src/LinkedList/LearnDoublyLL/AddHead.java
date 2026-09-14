package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class AddHead {
    public static Node arrayToDLL(int[] array) {
        return ArrayToDLL.arrayToDLL(array);
    }

    public static Node addHead(Node head, Node node) {

        // agar kuch nhi h toh
        if (head == null) {
            return node;
        }

        // head ke prev ko new node pe point kr do
        head.prev = node;

        // node ke next ko abhi jo head hai uspe point kr do
        node.next = head;

        // head ko node pe point kr do
        head = node;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        // DLL before adding head
        Node temp = head;

        System.out.println("Before Adding Head:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print("\nEnter value to add at head: ");
        int value = sc.nextInt();

        Node node = new Node(value);

        // add node at head
        head = addHead(head, node);

        // DLL after adding head
        temp = head;

        System.out.println("After Adding Head:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}