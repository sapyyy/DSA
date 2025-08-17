package Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack(st);
        insertAtLast(st, top);
    }

    public static void insertAtLast(Stack<Integer> st, int ele) {
        if (st.isEmpty()) {
            st.push(ele);
            return;
        }

        int top = st.pop();
        insertAtLast(st, ele);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack <Integer> st = new Stack<>();
        st.push(5);
        st.push(9);
        st.push(3);
        st.push(2);
        reverseStack(st);
        System.out.println(st);
    }
}
