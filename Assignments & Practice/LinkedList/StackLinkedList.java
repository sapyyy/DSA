import java.util.*;

/* 1. Write a program to implement a stack using linked list, such that the operations ‘push’
and ‘pop’ are performed in constant time. */

class Stack <T> {
    DoublyLinkedList <T> list;
    int size;
    int totalEle;

    Stack (int size) {
        list = new DoublyLinkedList <T> ();
        this.size = size;
        this.totalEle = 0;
    }
    
    // push method to add elements to the stack
    public void push(T data){
        if (list.head == null) {
            list.create(data);
            totalEle++;
        }
        else if (totalEle < size){
            list.insertFront(data);
            totalEle++;
        }
        else {
            System.out.println("Stack Overflow!");
        }
    }

    // pop method to remove elements from the stack
    public T pop(){
        if (list.head == null){
            System.out.println("Stack Underflow!");
            return null;
        }
        else {
            T data = list.head.data;
            list.deleteFront();
            return data;
        }
    }
 
    // display method to print the stack
    public void display(){
        list.display();
    }
}

public class StackLinkedList {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack <> (5);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.display();
    }
}
