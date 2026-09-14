package LinkedList.LearnDoublyLL;

public class DeleteTail {
    public static Node arrayToDLL(int[] array) {
        return ArrayToDLL.arrayToDLL(array);
    }

    public static Node deleteTail(Node head) {

        // agar kuch nhi hai toh
        if (head == null) {
            return null;
        }

        // agar bas head hua toh
        if (head.next == null) {
            return null;
        }

        Node temp = head;

        // 2nd last tk traverse kro
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // 2nd last ke next ko null pe point kr do
        temp.next = null;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        // DLL before deletion
        Node temp = head;

        System.out.println("Before Deletion:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        // delete tail
        head = deleteTail(head);

        // DLL after deletion
        temp = head;

        System.out.println("\nAfter Deletion:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}