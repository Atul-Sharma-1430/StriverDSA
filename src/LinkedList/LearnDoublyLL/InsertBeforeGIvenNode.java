package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class InsertBeforeGIvenNode {

    public static Node insertBeforeKthNode(Node head, int k, int value) {

        // k-th node tak jao
        Node temp = head;

        int count = 1;

        while (count < k) {
            temp = temp.next;
            count++;
        }

        // new node create karo
        Node newNode = new Node(value);

        // new node ko temp ke previous se connect karo
        newNode.prev = temp.prev;

        // new node ko temp se connect karo
        newNode.next = temp;

        // agar temp head tha
        if (temp.prev == null) {
            head = newNode;
        } else {
            // previous node ka next new node hoga
            temp.prev.next = newNode;
        }

        // temp ka previous new node hoga
        temp.prev = newNode;

        return head;
    }

    public static void printDLL(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        head = insertBeforeKthNode(head, k, value);

        System.out.println("DLL after insertion:");
        printDLL(head);

        sc.close();
    }
}