package LinkedList.Learn1DLL;

public class LengthOfLL {

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

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 8, 3, 4, 5, 7};

        Node head = convertArrayToLL(arr);

        // Traverse karne ke liye temp node banayenge kyuki head ko move nahi karna hai
        Node temp = head;

        // Keep a counter a track length
        int count = 0;

        // Jab tak last node tak nahi pahunchte
        while (temp != null) {

            count++;

            // Current node ka data print karenge
            System.out.print(temp.data + " ");

            // Next node par move karenge
            temp = temp.next;
        }

        System.out.println();
        System.out.println("Length of LL is : " + count);
    }
}