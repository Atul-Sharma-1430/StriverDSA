package LinkedList.Learn1DLL;

public class InsertionAtHeadOfLL {
    public static Node convertArrayToLL(int[] arr) {

        // Pahle element ko head bana denge
        Node head = new Node(arr[0]);

        // Mover node ko head par rakhenge jo aage nodes ko link karega
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {

            // Current element ke liye ek new node banayenge
            Node temp = new Node(arr[i]);

            // Mover ke next mein temp ko daal kar nodes ko link kar denge
            mover.next = temp;

            // Mover ko temp par shift kar denge
            mover = temp;
        }

        return head;
    }

    // Node = class
    // new Node() = object
    // head, node, temp = references
    // next = ek reference jo next Node object ko point karta hai
    public static Node insertHead(Node head, Node node) {

        // New node ko current head se link kar denge
        node.next = head;

        // New node ko head bana denge
        head = node;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 8, 3, 4, 5, 7};

        // Array ko Linked List mein convert karenge
        Node head = convertArrayToLL(arr);

        // Before daddition
        Node temp1 = head;

        while (temp1 != null) {

            // Current node ka data print karenge
            System.out.print(temp1.data + " ");

            // Next node par move karenge
            temp1 = temp1.next;
        }

        Node newHead = new Node(10);

        // head add karenge
        head = insertHead(head, newHead);

        System.out.println();

        // After addition
        Node temp = head;

        while (temp != null) {

            // Current node ka data print karenge
            System.out.print(temp.data + " ");

            // Next node par move karenge
            temp = temp.next;
        }
    }
}
