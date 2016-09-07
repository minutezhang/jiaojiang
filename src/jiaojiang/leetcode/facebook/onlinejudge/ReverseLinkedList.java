package jiaojiang.leetcode.facebook.onlinejudge;

import utils.ListNode;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class ReverseLinkedList {
    /*
    Reverse a singly linked list.
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
}
