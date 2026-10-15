package LinkedList.HardProblemOfLL;

import java.util.Scanner;

public class SortLL012 {
    // TC : O(n)
    // SC : O(1)
    public static Node function(Node head) {

        // agar list empty hai ya sirf ek node hai toh wahi return karo
        if (head == null || head.next == null) {
            return head;
        }

        // 0, 1 aur 2 ke liye alag-alag lists banayi
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        // Teeno lists ke starting nodes save kar liye Kyuki zero, one aur two pointers aage move hote rahenge
        Node zeroHead = zero;
        Node oneHead = one;
        Node twoHead = two;

        // Original linked list ko traverse karne ke liye
        Node temp = head;

        while (temp != null) {

            // Agar current node ka data 0 hai toh zero list mein add karo
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;

                // Agar current node ka data 1 hai toh one list mein add karo
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;

                // Otherwise current node ka data 2 hai toh two list mein add karo
            } else {
                two.next = temp;
                two = two.next;
            }

            // Original list ke next node par move karo
            temp = temp.next;
        }

        // Zero list ke end ko one list se connect karo
        // Agar one list empty hai toh directly two list se connect karo
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;

        // One list ke end ko two list ke start se connect karo
        one.next = twoHead.next;

        // Two list ke last node ka next null karo Taaki purana connection rehkar problem create na kare
        two.next = null;

        // Zero list ke head se poori sorted linked list return karo
        return zeroHead.next;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        System.out.println("Enter " + n + " elements (0, 1, or 2):");

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }

        head = function(head);

        System.out.println("Sorted Linked List:");

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}