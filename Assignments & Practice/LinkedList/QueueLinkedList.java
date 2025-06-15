import java.util.*;

class Queue <T> {
    DoublyLinkedList <T> list;
    int size;
    int totalEle;

    Queue (int size) {
        list = new DoublyLinkedList <> ();
        this.size = size;
        totalEle = 0;
    }

    // method to perform enqueue operation
    public void enqueue(T data) {
        if (list.head == null) {
            list.create(data);
            totalEle++;
        }
        else if (totalEle < size){
            list.insertEnd(data);
            totalEle++;
        }
        else {
            System.out.println("Queue Overflow");
        }
    }

    // method to perform dequeue operation
    public T dequeue() {
        if (list.head == null) {
            System.out.println("Queue Underflow");
            return null;
        }
        else {
            T ele = list.head.data;
            list.deleteFront();
            totalEle--;
            return ele;
        }
    }

    // method to display the queue
    public void display() {
        list.display();
    }
}

public class QueueLinkedList {
    public static void main (String[] args) {
        Queue <Integer> queue = new Queue <> (5);
        queue.enqueue(10);
        queue.enqueue(29);
        queue.enqueue(48);
        queue.enqueue(9);
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }
}
