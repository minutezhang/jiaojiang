package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 2/5/15 10:21 PM
 */
public class RemoveDuplicatesFromSortedListII {
    /*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (ListNode preNode = dummyHead, currentNode = preNode.next; currentNode != null; currentNode = preNode.next) {
            int currentValue = currentNode.val, count = 0;
            ListNode node;
            for (node = currentNode.next; node != null && node.val == currentValue; node = node.next, count++);
            if (count > 0) {
                preNode.next = node;
            } else {
                preNode = preNode.next;
            }
        }

        return dummyHead.next;
    }
}
