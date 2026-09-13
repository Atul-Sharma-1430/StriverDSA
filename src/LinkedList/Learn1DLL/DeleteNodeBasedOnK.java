package LinkedList.Learn1DLL;

public class DeleteNodeBasedOnK {

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

    public static Node delete(Node head, int k) {

        // If head is null
        if (head == null) {
            return head;
        }

        // Length of Linked List count karenge
        int length = 0;
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Agar k Linked List ke size se bada hai
        if (k > length) {
            return head;
        }

        // Agar first element delete karna hai
        if (k == 1) {
            head = head.next;
            return head;
        }

        // Kth element se just pehle wale node tak jayenge
        temp = head;
        int count = 1;

        while (count != k - 1) {
            count++;
            temp = temp.next;
        }

        // Kth node ko skip kar denge
        temp.next = temp.next.next;

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
        head = delete(head, 11);

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
