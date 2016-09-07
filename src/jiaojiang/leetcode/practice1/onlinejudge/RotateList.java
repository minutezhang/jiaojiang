package jiaojiang.leetcode.practice1.onlinejudge;

import utils.ListNode;

/**
 * @author: zhang
 * @since: May 6, 2013 10:35:22 PM
 */
public class RotateList {
    /*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode frontNode = head, backNode = head;
        for (int i = 0; i < n; i++) {
            if (frontNode.next == null) {
                frontNode = head;
            } else {
                frontNode = frontNode.next;
            }
        }

        for (; frontNode.next != null; frontNode = frontNode.next, backNode = backNode.next);

        if (backNode == frontNode) {
            return head;
        }

        ListNode node = backNode.next;
        backNode.next = null;
        frontNode.next = head;
        
        return node;
    }

    public static void test() {
//        rotateRight(getLinkedList(), 2).print(); // 4->5->1->2->3->null
//        rotateRight(getLinkedList(), 9).print(); // 2->3->4->5->1->null
//        rotateRight(getLinkedList2(), 1).print(); // 2->1->null
        ListNode.print(rotateRight(getLinkedList2(), 2)); // 1->2->null
//        rotateRight(new ListNode(1), 2).print(); // 1->null
    }

    public static ListNode getLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public static ListNode getLinkedList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        return head;
    }

    public static void main(String[] args) {
        test();
    }
    
}
