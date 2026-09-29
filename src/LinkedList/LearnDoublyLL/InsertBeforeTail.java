package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class InsertBeforeTail {

    public static Node insertBeforeTail(Node head, int value) {

        // tail tak jao
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // new node create karo
        Node newNode = new Node(value);

        // new node ko tail ke previous se connect karo
        newNode.prev = temp.prev;

        // new node ko tail se connect karo
        newNode.next = temp;

        // agar tail hi head tha
        if (temp.prev == null) {
            head = newNode;
        } else {
            // tail ke previous node ka next new node hoga
            temp.prev.next = newNode;
        }

        // tail ka previous new node hoga
        temp.prev = newNode;

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {

            int data = sc.nextInt();

            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                newNode.prev = temp;
                temp = newNode;
            }
        }

        System.out.print("Enter value to insert before tail: ");
        int value = sc.nextInt();

        head = insertBeforeTail(head, value);

        System.out.println("DLL after insertion:");

        temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}