package LinkedList.LearnDoublyLL;

public class DeleteHead {
    public static Node arrayToDLL(int[] array) {
        return ArrayToDLL.arrayToDLL(array);
    }

    public static Node deleteHead(Node head) {

        if (head == null || head.next == null) {
            return null;
        }
        // Mode head pointer to current head ke next pe
        head = head.next;
        // and new head ke prev me null daal do
        head.prev = null;
        // return new head
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0};

        // array to DLL
        Node head = arrayToDLL(arr);

        //head before deletion
        System.out.println(head.data);

        // newNode
        Node newHead = deleteHead(head);

        // head after deletion
        System.out.println(newHead.data);

    }
}
