package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 1/29/15 3:07 PM
 */
public class ReorderList {
    /*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public static void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode node, node2;
        for(node = head, node2 = head; node2 != null && node2.next != null; node = node.next, node2 = node2.next.next);

        node2 = node.next;
        node.next = null;

        //reverse the list
        ListNode dummyNode = new ListNode(0);
        while (node2 != null) {
            ListNode next = node2.next;
            node2.next = dummyNode.next;
            dummyNode.next = node2;
            node2 = next;
        }

        //interleave
        for(node = head, node2 = dummyNode.next; node2 != null;) {
            ListNode next = node2.next;
            node2.next = node.next;
            node.next = node2;
            node = node2.next;
            node2 = next;
        }
    }
}
