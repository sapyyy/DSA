import java.util.*;

class DoublyLinkedList <T> {
    Node <T> head;
    int totalNodes;

    class Node <T> {
        Node <T> prev;
        Node <T> next;
        T data;
        
        // constructor
        Node (T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    
        Node (T data, Node <T> prev, Node <T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // method to create the first node of the list
    public void create(T data){
        if (head == null) {
            Node <T> p = new Node <> (data);
            head = p;
            System.out.println("Successfully Inserted - Head Node");
            totalNodes = 1;
        }
        else {
            System.out.println("The linked list already contains a head node");
        }
    }

    // method to perform insertion in the doubly linked list
    public void insertFront(T data){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        Node <T> newNode = new Node(data, null, p);
        p.prev = newNode;
        head = newNode;
        totalNodes++;
    }

    public void insertEnd(T data){
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        while (p.next != null) {
            p = p.next;
        }
        Node <T> newNode = new Node(data, p, null);
        p.next = newNode;
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
    
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        totalNodes--;
    }
    
    public void deleteEnd() {
        if (head == null) {
            System.out.println("The linked list is - empty");
            return;
        }

        Node <T> p = head;
        while (p.next != null){
            p = p.next;
        }
        Node <T> prevP = p.prev;
        p.prev = null;
        prevP.next = null;
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

    // method to display the list
    public void display(){
        if (head == null) {
            System.out.println("The list is - empty");
        }
        else {
            Node <T> p = head;
            while (p.next != null) {
                System.out.print(p.data + " -> ");
                p = p.next;
            }
            System.out.print(p.data);
        }
    }
}



public class DoublyList {
    public static void main(String[] args) {
        DoublyLinkedList <Integer> doubly = new DoublyLinkedList <> ();
        doubly.create(43);
        doubly.insertFront(39);
        doubly.insertEnd(30);
        doubly.insertMid(84,2);
        doubly.deleteMid(3);
        doubly.deleteFront();
        doubly.deleteEnd();
        doubly.display();
    }
}
