class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        // constructor
        Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    // instance-variables
    Node head;

    // creation of methods
    // to create nodes
    public void createNode(int data) {
        if (head==null) {
            head = new Node(data, null);
            System.out.println("Insertion Successfull");
        }
        else {
            System.out.println("There is already a node");
        }
    }

    // to insert an element at the first position
    public void insertFront(int data) {
        if (head==null) {
            createNode(data);
        }
        else {
            Node newNode = new Node(data, head);
            head = newNode;
            System.out.println("Insertion Successfull");
        }
    }

    // method to display the whole linked list
    public void display(){
        Node p = head;
        while (p.next != null) {
            System.out.print(p.data + " => ");
            p = p.next;
        }
        System.out.println(p.data);
    }
}

public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.createNode(57);
        list.insertFront(83);
        list.insertFront(38);
        list.insertFront(23);
        list.display();
    }
}
