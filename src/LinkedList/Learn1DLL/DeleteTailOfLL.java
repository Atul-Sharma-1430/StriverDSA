package LinkedList.Learn1DLL;

public class DeleteTailOfLL {

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

    public static Node deleteTail(Node head) {

        // Agar Linked List empty hai to kuch delete nahi karna
        if (head == null) {
            return null;
        }

        // Agar sirf ek hi node hai to head ko null kar denge
        if (head.next == null) {
            return null;
        }

        Node temp = head;

        // Second last node tak jayenge
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Last node ka link hata denge
        temp.next = null;

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

        // Tail delete karenge
        head = deleteTail(head);

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