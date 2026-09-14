package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class DeleteKthNode {
    public static Node arrayToDLL(int[] arr) {
        return ArrayToDLL.arrayToDLL(arr);
    }

    public static Node deleteKthNode(Node head, int k) {

        if (head == null) {
            return null;
        }

        // agar head delete karna hai
        if (k == 1) {
            return DeleteHead.deleteHead(head);
        }

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;

            // jis node ko delete krna hai uspe pahuch gye toh
            if (count == k) {
                // us node ke prev node ke next ko curr node ke next pr point krwa do
                temp.prev.next = temp.next;

                if (temp.next != null) {
                    // agar next node null nhi hai toh next node ke prev me curr node ka prev daal do
                    temp.next.prev = temp.prev;
                }

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // DLL before deletion
        Node temp = head;

        System.out.println("Before Deletion:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        // delete kth node
        head = deleteKthNode(head, k);

        // DLL after deletion
        temp = head;

        System.out.println("\nAfter Deletion:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}