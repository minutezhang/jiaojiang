package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 2/6/15 11:52 PM
 */
public class RotateList {
    /*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
     */
    public static ListNode rotateRight(ListNode head, int n) {
        int i;
        ListNode firstNode, secondNode;
        for (i = 0, firstNode = head; i < n && firstNode != null; firstNode = firstNode.next, i++);

        if (firstNode == null) {
            if (i == 0 || i == n) {
                return head;
            }
            for (n %= i, i = 0, firstNode = head; i < n && firstNode != null; firstNode = firstNode.next, i++);
        }

        for (secondNode = head; firstNode.next != null; firstNode = firstNode.next, secondNode = secondNode.next);

        firstNode.next = head;
        head = secondNode.next;
        secondNode.next = null;

        return head;
    }
}
