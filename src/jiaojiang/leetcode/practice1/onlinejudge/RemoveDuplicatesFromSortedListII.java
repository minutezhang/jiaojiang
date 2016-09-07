package jiaojiang.leetcode.practice1.onlinejudge;

import utils.ListNode;

/**
 * @author: zhang
 * @since: Apr 22, 2013 10:00:04 PM
 */
public class RemoveDuplicatesFromSortedListII {
    /*
     Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode fakeHead = new ListNode(head == null ? 0 : head.val == Integer.MAX_VALUE ? head.val - 1 : head.val + 1);        // use fakeHead to avoid multiple while loop
        fakeHead.next = head;
        ListNode preNode = fakeHead, node = head;

        while (node != null) {
            int i = 0;
            ListNode n = node;
            while (n.next != null && n.next.val == node.val) {
                i++;
                n = n.next;
            }

            if (i == 0) {
                preNode.next = node;
                preNode = node;
            }

            node = n.next;
        }

        preNode.next = null;

        return fakeHead.next;
    }
}
