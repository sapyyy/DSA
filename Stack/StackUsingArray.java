package Stack;

import java.util.*;

class StackArr {
    private int[] arr;
    int top = -1;
    int size;

    StackArr(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int ele) {
        if (top < size-1)  {
            arr[++top] = ele;
            System.out.println("Insertion successfull");
        }
        else {
            System.out.println("Stack overflow!");
        }
    }

    public int pop() {
        if (top != -1) {
            return arr[top--];
        }
        else {
            System.out.println("Stack Underflow");
        }

        return -1;
    }

    public int peek() {
        if (top != -1) {
            return arr[top];
        }
        else {
            System.out.println("Stack is empty");
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The  stack : ");
            for (int i = top; i>=0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        StackArr stack = new StackArr(5);
        stack.push(5);
        stack.push(43);
        stack.push(2);
        stack.push(58);
        stack.push(58);
        stack.push(58);
        stack.display();
    }
}
