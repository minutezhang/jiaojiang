package jiaojiang.leetcode.practice4.onlinejudge;

import utils.ListNode;

/**
 * @author zhang
 *
 * Created on Mar 8, 2016
 */
public class ReverseLinkedList {
    /*
    Reverse a singly linked list.

    click to show more hints.
    Hint:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode dummyHead = new ListNode(0);

        for (ListNode node = head, nextNode; node != null; node = nextNode) {
            nextNode = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }
}
