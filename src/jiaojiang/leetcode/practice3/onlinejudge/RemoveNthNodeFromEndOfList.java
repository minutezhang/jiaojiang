package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 1/28/15 11:41 AM
 */
public class RemoveNthNodeFromEndOfList {
    /*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

       Given linked list: 1->2->3->4->5, and n = 2.

       After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head, node2 = head;
        for (int i = 0; i < n && node2 != null; node2 = node2.next, i++);

        if (node2 == null) {
            return head.next;
        }

        for (; node2.next != null; node1 = node1.next, node2 = node2.next);

        if (node1.next != null) {
            node1.next = node1.next.next;
        }

        return head;
    }
}
