package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class AddTail {
    public static Node arrayToDLL(int[] array) {
        return ArrayToDLL.arrayToDLL(array);
    }

    public static Node addTail(Node head, Node tail) {

        // agar list empty hai
        if (head == null) {
            return tail;
        }

        Node temp = head;

        // last node tak jao
        while (temp.next != null) {
            temp = temp.next;
        }

        // last node ka next new node pe point kr denge
        temp.next = tail;

        // new node ka prev last node pe point kr denge
        tail.prev = temp;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        // before adding tail
        Node temp = head;

        System.out.println("Before Adding Tail:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print("\nEnter value to add at tail: ");
        int value = sc.nextInt();

        Node tail = new Node(value);

        // add node at tail
        head = addTail(head, tail);

        // after adding tail
        temp = head;

        System.out.println("After Adding Tail:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}