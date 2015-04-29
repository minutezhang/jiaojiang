package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 2/7/15 11:24 PM
 */
public class MergeTwoSortedLists {
    /*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
    nodes of the first two lists.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), node = dummyHead, node1 = l1, node2 = l2;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }

        if (node1 != null) {
            node.next = node1;
        } else {
            node.next = node2;
        }

        return dummyHead.next;
    }
}
