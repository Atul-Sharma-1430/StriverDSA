package LinkedList.Learn1DLL;

public class InsertDataAsHeadOfLL {

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

    public static Node insertHead(Node head, int data) {

        if (head == null) {
            return new Node(data);
        }

        // Create a node with given data
        Node temp = new Node(data);

        // move the next pointer of temp to head
        temp.next = head;

        // move head pointer to next
        head = temp;

        return head;
    }

    // New node banao, uska data data rakho aur uska next purane head ko point kara do.
    public static Node insertHead2(Node head, int data) {
        return new Node(data, head);
    }

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 8, 3, 4, 5, 7};

        // Array ko Linked List mein convert karenge
        Node head = convertArrayToLL(arr);

        // New data ko head par insert karenge
        head = insertHead2(head, 10);

        // Linked List print karenge
        Node temp = head;

        while (temp != null) {

            // Current node ka data print karenge
            System.out.print(temp.data + " ");

            // Next node par move karenge
            temp = temp.next;
        }
    }
}