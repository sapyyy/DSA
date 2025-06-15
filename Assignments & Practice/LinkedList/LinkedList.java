package LinkedListAssignment;

import java.util.*;

/* Singly Linked List
1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists */

// represents every node in the linked list
class Node <T> {
    T data;
    Node <T> next;

    // constructor that initialises the data and the next part to null
    Node(T data){
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList <T> {
    Node <T> head;
    int totalEle;

    // create method which is used to create the first node of the list
    public void create(T data){
        Node <T> newNode = new Node <> (data);

        // checking if the linked list already created
        if (head == null){
            head = newNode;
            totalEle = 1;
            System.out.println("Linked List Creation Successful");
        }
        else {
            System.out.println("The linked list is already created");
        }
    }

    public void display(){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            Node <T> p = head;

            while (p.next != null) {
                System.out.print(p.data + " -> ");
                p = p.next;
            }

            System.out.println(p.data);
        }
    }

    /* INSERTION */
    public void insertBeg(T data){
        Node <T> newNode = new Node <> (data);

        if (head == null){
            System.out.println("Insertion Error, the linked list is empty");
        }
        else {
            // the newNode's next will be pointing to the original head
            newNode.next = head;
            // the new head will be the newNode
            head = newNode;
            totalEle++;
        }
    }

    public void insertEnd(T data){
        Node <T> newNode = new Node <> (data);

        if (head == null){
            System.out.println("Insertion Error, the linked list is empty");
        }
        else {
            Node <T> p = head;

            // traverse to the last node where p.next is not null
            while (p.next != null){
                p = p.next;
            }

            p.next = newNode;
            totalEle++;
        }
    }

    public void insertAtPos(int pos, T data){
        Node <T> newNode = new Node <> (data);

        if (pos >= 1 && pos <= totalEle + 1){
            // if pos is 1 then it is insertion at the beginning
            if (pos == 1){
                insertBeg(data);
                return;
            }
            // similarly if it is 1 more than the no of elements, then it is insertion at the end
            else if (pos == totalEle + 1){
                insertEnd(data);
                return;
            }
            else {
                Node <T> p = head;

                // traverse until pos - 1 and then add the newNode
                int c = 1;
                while (c != pos - 1){
                    p = p.next;
                    c++;
                }

                // change the newNode's next to p's next
                newNode.next = p.next;
                p.next = newNode;
            }
        }
        else {
            System.out.println("Insertion Error, mentioned position is invalid");
        }
    }

    /* DELETION */
    public void deleteBeg(){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            // the p now points to the first node
            Node <T> p = head;
            // now the head points to the second node
            head = p.next;
            p.next = null;
            totalEle--;
        }
    }

    public void deleteEnd(){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        // if the totalEle is 1, we simply perform the deleteBeg
        else if (totalEle == 1){
            deleteBeg();
        }
        else {
            Node <T> p = head;

            // traverse and store two consecutive elements till the end
            Node <T> secondLast = head;
            while (p.next != null){
                secondLast = p;
                p = p.next;
            }

            secondLast.next = null;
            totalEle--;
        }
    }

    public void deleteAtPos(int pos){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else if (pos < 1 && pos > totalEle + 1) {
            System.out.println("Deletion failed, mentioned position is invalid");
        }
        else {
            Node <T> p = head;

            // if the pos is 1, then perform delete beg
            if (pos == 1){
                deleteBeg();
            }
            // if the pos is 1 more than totalEle then perform delete end
            else if (pos == totalEle + 1) {
                deleteEnd();
            }
            else {
                // traverse till pos - 1
                int c = 0;
                while (c != pos - 1){
                    p = p.next;
                    c++;
                }

                // and then take a temp to store the node to be removed
                Node <T> temp = p.next;
                // temp's next node should be the pointer's next node
                p.next = temp.next;
                // finally temp next should point to null
                temp.next = null;
                totalEle--;
            }
        }
    }

    // method to perform linear search
    public boolean linearSearch(T data){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            Node <T> p = head;

            int pos = 1;
            while (p != null){
                // traverse till the end, and if data is matched return true else false
                if (p.data == data){
                    System.out.println("Search Successful, index : "+pos);
                    return true;
                }

                p = p.next;
                pos++;
            }
        }

        System.out.println("Search Unsuccessful, element not found");
        return false;
    }

    // method to perform insertion based on a specified element
    public void insertAfterEle(T data, T newData){
        Node <T> newNode = new Node <> (newData);
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            Node <T> p = head;

            // traverse till the element is found
            boolean found = false;
            while (p != null){
                if (p.data.equals(data)){
                    found = true;
                    break;
                }
                p = p.next;
            }

            if (found){
                newNode.next = p.next;
                p.next = newNode;
                totalEle++;
            }
            else {
                System.out.println("Insertion failed, mentioned element is not present in the linked list");
            }
        }
    }

    // method to delete a specified element
    public void deleteByEle(T data){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else{
            Node <T> p = head;

            boolean found = false;
            Node <T> prev = p;
            while (p != null){
                if (p.data.equals(data)){
                    found = true;
                    break;
                }

                prev = p;
                p = p.next;
            }

            if (found){
                prev.next = p.next;
                p.next = null;
                totalEle--;
            }
            else {
                System.out.println("Deletion failed, mentioned element is not present in the linked list");
            }
        }
    }

    public int countNodes(){
        return totalEle;
    }

    /* REVERSION */

    // method to reverse a list by data
    public void reverseListByData(){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            // if list has only one element no need to reverse
            if (totalEle == 1){
                return;
            }
            else {
                Stack <T> stack = new Stack <> ();

                // pushing all the elements to the stack
                Node <T> p = head;
                while (p != null) {
                    stack.push(p.data);
                    p = p.next;
                }

                // popping all the elements and then storing in the linked list again
                p = head;
                while (!stack.empty() && p != null) {
                    p.data = stack.pop();
                    p = p.next;
                }

                System.out.println("Reverse Successful, all the elements are reversed by data");
            }
        }
    }

    public void reverseByNodes(){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        else {
            // if list has only one element no need to reverse
            if (totalEle == 1) {
                return;
            }
            else {
                Node<T> prev = null;
                Node<T> cur = head;
                Node<T> after = null;

                // now we traverse until the cur is null
                while (cur != null) {
                    // we store the new node inside the after variable
                    after = cur.next;
                    // then we change the cur.next to the prev variable
                    cur.next = prev;

                    // now we move to the next node by changing the cur to prev
                    prev = cur;
                    // and now the after node is the new cur
                    cur = after;
                }

                head = prev;
            }

            System.out.println("Reversion Successful, the list is reversed by nodes");
        }
    }

    // method to reverse the linked list by nodes but with recursion


    // method to concat two lists
    public static <E> void concatTwoList(SinglyLinkedList <E> list1, SinglyLinkedList <E> list2) {
        // check whether both the linked list are not null
        if (list1.head == null || list2.head == null){
            System.out.println("To concat two list make sure both of the list are not empty");
        }
        else {
            Node <E> p = list1.head;

            // traverse till the end of the first list
            while (p.next != null) {
                p = p.next;
            }

            // now we just point the p.next which is null now, to be the head of the list2
            p.next = list2.head;
            // now we make the list2 head to point at the same head as list1
            list2.head = list1.head;
            System.out.println("Concatenation successful, the two lists are joined now in list1");
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList <Integer> list = new SinglyLinkedList <> ();
        list.create(39);

        // insertion
        list.insertBeg(29);
        list.insertBeg(9);
        list.insertEnd(74);
        list.insertEnd(7);
        list.insertEnd(4);
        list.insertEnd(84);
        list.insertAtPos(3,5);

        // deletion
        list.deleteBeg();
        list.deleteEnd();
        list.deleteAtPos(2);

        // search
        list.linearSearch(5);

        // insert after specified element
        list.insertAfterEle(5, 50);

        // delete a specified element
        list.deleteByEle(5);

        // count no of nodes
        System.out.println(list.countNodes());

        // reverse the list
        list.reverseByNodes();

        // reverse the list by data
        list.reverseListByData();

        // concatenate another list
        SinglyLinkedList <Integer> list2 = new SinglyLinkedList<>();
        list2.create(39);
        list2.insertEnd(35);
        list2.insertEnd(93);
        SinglyLinkedList.concatTwoList(list, list2);

        // display
        list.display();
    }
}