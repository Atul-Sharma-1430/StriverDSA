package LinkedList.Learn1DLL;

public class DeleteNodeBasedOnValue {
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

    public static Node deleteNode(Node head, int data) {

        if (head == null) {
            return head;
        }

        // Agar head mein hi data hai toh head ke next ko as head return kr do
        if (head.data == data) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        // Agar data mila hi nahi
        if (temp == null) {
            return head;
        }

        // Current node ko skip kar denge
        prev.next = prev.next.next;

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

        // Kth element delete karenge
        head = deleteNode(head, 7);

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
