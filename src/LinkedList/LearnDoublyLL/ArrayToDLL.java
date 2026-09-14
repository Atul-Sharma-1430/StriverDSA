package LinkedList.LearnDoublyLL;

public class ArrayToDLL {
    public static Node arrayToDLL(int[] array) {
        Node head = new Node(array[0]);

        Node prev = head;

        for (int i = 1; i < array.length; i++) {
            // directly yha bhi kr sakte hai
            Node newNode = new Node(prev, array[i]);

            // Previous node ke next me current node
            prev.next = newNode;

            // Current node ka prev me prev node
            // newNode.prev = prev;

            prev = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        Node head = arrayToDLL(arr);

        Node temp = head;

        while (temp != null) {

            System.out.print("[");
            if (temp.prev != null) {
                System.out.print(temp.prev.data);
            } else {
                System.out.print("null");
            }

            System.out.print("|");
            System.out.print(temp.data);
            System.out.print("|");

            if (temp.next != null) {
                System.out.print(temp.next.data);
            } else {
                System.out.print("null");
            }

            System.out.print("]");

            if (temp.next != null) {
                System.out.print(" --> ");
            }


            temp = temp.next;
        }
    }
}