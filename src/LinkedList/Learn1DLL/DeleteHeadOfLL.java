package LinkedList.Learn1DLL;

public class DeleteHeadOfLL {

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

    public static Node deleteHead(Node head) {

        // Agar Linked List empty hai to kuch delete nahi karna
        if (head == null) {
            return head;
        }

        // Head ko next node par shift kar denge
        head = head.next;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 8, 3, 4, 5, 7};

        // Array ko Linked List mein convert karenge
        Node head = convertArrayToLL(arr);

        // Before deletion
        Node temp1 = head;
        while (temp1 != null) {

            // Current node ka data print karenge
            System.out.print(temp1.data + " ");

            // Next node par move karenge
            temp1 = temp1.next;
        }

        // Head delete karenge
        head = deleteHead(head);

        System.out.println();

        // After deletion
        Node temp = head;
        while (temp != null) {

            // Current node ka data print karenge
            System.out.print(temp.data + " ");

            // Next node par move karenge
            temp = temp.next;
        }
    }
}