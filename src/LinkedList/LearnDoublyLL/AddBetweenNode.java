package LinkedList.LearnDoublyLL;

import java.util.Scanner;

public class AddBetweenNode {
    public static Node arrayToDLL(int[] array) {
        return ArrayToDLL.arrayToDLL(array);
    }

    public static Node addBetweenNode(Node head, int data, int k) {

        // Agar kuch nhi hua and k 1 hua toh
        if (head == null && k == 1) {
            return new Node(data);
        }

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;

            // Traverse krte time agar count k ke equal hua toh
            if (count == k) {

                // newNode banayenge
                Node newNode = new Node(data);

                // newNode ke prev ko temp pe point kr denge
                newNode.prev = temp;
                // newNode ke next ko temp ke next pe point kr denge
                newNode.next = temp.next;

                // agar next elem exist krta hai tab uske prev ko newNode pe point kr denge
                if (temp.next != null) {
                    temp.next.prev = newNode;
                }

                // and last me temp ke next ko newNode pe point kr denge
                temp.next = newNode;

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

        // before adding node
        Node temp = head;

        System.out.println("Before Adding Node:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print("\nEnter value to add: ");
        int data = sc.nextInt();

        System.out.print("Enter position after which you want to add: ");
        int k = sc.nextInt();

        // add node between
        head = addBetweenNode(head, data, k);

        // after adding node
        temp = head;

        System.out.println("After Adding Node:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}