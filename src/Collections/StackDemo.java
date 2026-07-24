package Collections;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // TC: O(1) - Adds element to the top of the stack
        st.push(10);

        // TC: O(1) - Removes and returns the top element
        st.pop();

        // TC: O(1) - Returns the top element without removing it
        st.peek();

        // TC: O(1) - Returns true if the stack is empty
        st.empty();

        // TC: O(1) - Returns the number of elements in the stack
        st.size();

        // TC: O(n) - Returns 1-based position of the element from the top (-1 if not
        // found)
        st.search(10);

        // TC: O(n) - Removes all elements from the stack
        st.clear();
    }
}