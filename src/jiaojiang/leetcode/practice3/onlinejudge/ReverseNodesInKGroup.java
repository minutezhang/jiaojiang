package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 3/3/15 10:07 PM
 */
public class ReverseNodesInKGroup {
    /*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    You may not alter the values in the nodes, only nodes itself may be changed.

    Only constant memory is allowed.

    For example,
    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5
     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (ListNode preNode = dummyHead; preNode != null;) {
            ListNode endNode = preNode;
            for (int i = 0; i < k && endNode != null; endNode = endNode.next, i++);
            if (endNode == null) {
                return dummyHead.next;
            }
            preNode = reverseKNodes(preNode, endNode.next);
        }

        return dummyHead.next;
    }

    private static ListNode reverseKNodes(ListNode preNode, ListNode endNode) {
        ListNode node = preNode.next, retNode = preNode.next;
        preNode.next = endNode;

        while (node != endNode) {
            ListNode nextNode = node.next;
            node.next = preNode.next;
            preNode.next = node;
            node = nextNode;
        }

        return retNode;
    }
}
