package LinkedList.Learn1DLL;

public class SearchInLL {

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

        int target = arr[5];

        // Traverse karne ke liye temp node banayenge kyuki head ko move nahi karna hai
        Node temp = head;

        // Jab tak last node tak nahi pahunchte
        while (temp != null) {

            // Agar current node ka data target ke equal hai
            if (temp.data == target) {
                System.out.println("Target Found");
                break;
            }

            // Next node par move karenge
            temp = temp.next;
        }
    }
}