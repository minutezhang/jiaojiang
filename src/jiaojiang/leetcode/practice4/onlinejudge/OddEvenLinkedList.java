package jiaojiang.leetcode.practice4.onlinejudge;

import utils.ListNode;

/**
 * @author zhang
 *
 * Created on Feb 29, 2016
 */
public class OddEvenLinkedList {
    /*
    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
    talking about the node number and not the value in the nodes.

    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

    Example:
    Given 1->2->3->4->5->NULL,
    return 1->3->5->2->4->NULL.

    Note:
    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...
     */
    public static ListNode oddEvenList(ListNode head) {
        ListNode[] dummyNode = new ListNode[]{new ListNode(1), new ListNode(2)};
        ListNode oddDummyHead = dummyNode[0], evenDummyHead = dummyNode[1];
        for (int index = 0; head != null; head = head.next, index++) {
            dummyNode[index & 1].next = head;
            dummyNode[index & 1] = dummyNode[index & 1].next;
        }

        dummyNode[0].next = evenDummyHead.next;
        dummyNode[1].next = null;

        return oddDummyHead.next;
    }
}
