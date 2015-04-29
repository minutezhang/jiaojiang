package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 2/27/15 3:53 PM
 */
public class ReverseLinkedListII {
    /*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0), node = dummyHead, rNode, nextNode;
        int index = 1;
        dummyHead.next = head;

        for (; index < m && node != null; node = node.next, index++);

        if (node == null) {
            return dummyHead.next;
        }

        for (rNode = node, node = node.next, index++; index <= n && node.next != null; index++) {
            nextNode = node.next;
            node.next = nextNode.next;

            nextNode.next = rNode.next;
            rNode.next = nextNode;
        }

        return dummyHead.next;
    }
}
