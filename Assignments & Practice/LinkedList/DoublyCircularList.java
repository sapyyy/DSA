import java.util.*;

class Node <T> {
    Node <T> prev;
    Node <T> next;
    T data;

    Node (T data, Node <T> prev, Node <T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
} 

class DoublyCircularLinkedList <T> {
    Node <T> head;
    int totalNodes;

    // method to create the first node of the linked list
    public void create (T data) {
        if (head == null) {
            Node <T> newNode = new Node(data, null, null);
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
            totalNodes = 1;
        }
        else {
            System.out.println("The linked is already created");
        }
    }

    // method to perform insertion in the doubly linked list
     public void insertFront(T data){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> newNode = new Node(data, head.prev, head);
        head.prev = newNode;
        head = newNode;
        newNode.prev.next = newNode;
        totalNodes++;
    }

    public void insertEnd(T data){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        while (p.next != head) {
            p = p.next;
        }
        Node <T> newNode = new Node(data, p, head);
        p.next = newNode;
        head.prev = newNode;
        totalNodes++;
    }

    public void insertMid(T data, int index){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        if (index==1){
            insertFront(data);
            return;
        }
        else if (index==totalNodes){
            insertEnd(data);
            return;
        }
        else if (index>0 && index<=totalNodes){
            Node <T> p = head;
            int count = 1;
            while (count != (index - 1)) {
                p = p.next;
                count++;
            }

            Node <T> newNode = new Node(data, p, p.next);
            p.next.prev = newNode;
            p.next = newNode;
            totalNodes++;
        }
        else {
            System.out.println("Index Error, can't insert at the position");
        }
    }

    // method to delete nodes from the linked list
    public void deleteFront() {
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        head = p.next;

        // circular logic
        head.prev = p.prev;
        head.prev.next = head;

        p.next.prev = null;
        p.next = null;
        totalNodes--;
    }
    
    public void deleteEnd() {
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        while (p.next != head){
            p = p.next;
        }
        Node <T> prevP = p.prev;

        // circular logic
        prevP.next = head;
        head.prev = prevP;

        p.prev = null;
        p.next = null;
        totalNodes--;
    }

    public void deleteMid(int index) {
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        if (index==1){
            deleteFront();
            return;
        }
        else if (index==totalNodes){
            deleteEnd();
            return;
        }
        else if (index>0 && index<=totalNodes){
            Node <T> p = head;
            int count = 1;
            while (count != index) {
                p = p.next;
                count++;
            }

            Node <T> prevP = p.prev;
            p.prev = null;
            prevP.next = p.next;
            p.next = null;
            totalNodes--;
        }
        else {
            System.out.println("Index Error, can't insert at the position");
        }
    }

    // method to display the circular linked list
    public void display(){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }
        
        Node <T> p = head;
        while (p.next != head) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.print(p.data);
    }
}

public class DoublyCircularList {
    public static void main(String[] args) {
        DoublyCircularLinkedList <Integer> doubly = new DoublyCircularLinkedList <> ();
        doubly.create(8);
        doubly.insertFront(34);
        doubly.insertEnd(28);
        doubly.insertMid(34,3);
        doubly.deleteFront();
        doubly.deleteEnd();
        doubly.deleteMid(2);
        doubly.display();
    }
}
