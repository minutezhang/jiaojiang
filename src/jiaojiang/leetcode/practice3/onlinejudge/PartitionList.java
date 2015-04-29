package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 1/27/15 7:36 PM
 */
public class PartitionList {
    /*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
     */

    public static ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0), last = new ListNode(0), firstNode = first, lastNode = last;
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val < x) {
                firstNode.next = node;
                firstNode = firstNode.next;
            } else {
                lastNode.next = node;
                lastNode = lastNode.next;
            }
        }

        firstNode.next = last.next;
        lastNode.next = null;
        return first.next;
    }
}
