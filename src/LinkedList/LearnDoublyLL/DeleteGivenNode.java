package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class DeleteGivenNode {
    public static Node arrayToDLL(int[] arr) {
        return ArrayToDLL.arrayToDLL(arr);
    }

    public static void DeleteNode(Node node) {
        // agar single elem hai toh
        if (node.prev == null && node.next == null) {
            return;
        }

        Node prev = node.prev;
        Node front = node.next;

        // tail node ke liye
        if (front == null) {
            prev.next = null;
            node.prev = null;
            return;
        }

        // middle nodes ke liye
        prev.next = front;
        front.prev = prev;
        node.next = node.prev = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        // DLL before deleting node
        Node temp = head;

        System.out.println("Before Deleting Node:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print("\nEnter position of node to delete: ");
        int k = sc.nextInt();

        // given node ko find karenge
        temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // given node head nahi hona chahiye
        if (temp != null && temp != head) {
            // given node ko delete karenge
            DeleteNode(temp);
        }

        // DLL after deleting node
        temp = head;

        System.out.println("After Deleting Node:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}