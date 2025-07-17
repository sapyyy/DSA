package LinkedList;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class LC876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }

        return slow;
    }
}
