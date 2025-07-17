package LinkedList;

import java.util.*;

class DoublyLinkedList {
    static class Node {
    int data;
    Node next;
    Node prev;
    
    Node (int data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
    
    Node (int data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }
  Node head;
  
  // mehthod to convert an array to DoublyLinkedList
  public void convertToDoubly(int[] arr) {
    head = new Node(arr[0]);
    
    Node prev = head;
    
    if (arr.length == 1) return;
    
    for (int i=1; i<arr.length; i++) {
      Node newNode = new Node(arr[i], null, prev);
      
      prev.next = newNode;
      
      prev = newNode;
    }
  }
  
  // method to print the DoublyLinkedList
  public void print(){
    Node p = head;
    
    while (p.next != null) {
      System.out.print(p.data + " -> ");
      p = p.next;
    }
      System.out.print(p.data);
      System.out.println();
  }
  
  // method to insertAtTail
  public void insertAtTail(int data) {
    Node p = head;
    Node newNode = new Node(data);
    
    while (p.next != null) {
      p = p.next;
    }
    
    p.next = newNode;
    newNode.prev = p;
  }
  
  // method to delete a node in DoublyLinkedList
  public void deleteTailNode() {
    Node p = head;
    
    while (p.next != null) {
      p = p.next;
    }
    
    Node prev = p.prev;
    prev.next = null;
    p.prev = null;
  }
  
  // method to delete the headNod
  public void deleteHeadNode(){
    if (head.next == null) {
      return;
    }
    
    Node p = head;
    if (p.next == null) {
      head = null;
    }
    else {
      p = head.next;
      head.next = null;
      p.prev = null;
      head = p;
    }
  }
  
  // reverse a linked list using StackOverflowError
  public void reverse() {
    if (head == null) return;
    
    Node cur = head;
    Node prev = null;
    Node next = null;
    
    while (cur!=null) {
      next = cur.next;
      cur.next = prev;
      cur.prev = next;
      
      prev = cur;
      cur = next;
    }
    
    head = prev;
  }
}

public class DLinkedList {
    public static void main(String[] args) {
      DoublyLinkedList list1 = new DoublyLinkedList();
      list1.convertToDoubly(new int[]{1,2,3,4,5,6});
      list1.print();
      list1.insertAtTail(7);
      list1.print();
      list1.deleteTailNode();
      list1.print();
      list1.deleteHeadNode();
      list1.print();
      list1.reverse();
      list1.print();
  }
}
