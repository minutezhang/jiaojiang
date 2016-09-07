package jiaojiang.leetcode.practice4.onlinejudge;

import utils.ListNode;

import java.util.Random;

/**
 * @author zhang
 *
 * Created on Aug 9, 2016
 */
public class LinkedListRandomNode {
    /*
    Given a singly linked list, return a random node's value from the linked list. Each node must have the same
    probability of being chosen.

    Follow up:
    What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently
    without using extra space?

    Example:

    // Init a singly linked list [1,2,3].
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    Solution solution = new Solution(head);

    // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
    solution.getRandom();
     */

    private ListNode node;

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.node = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        ListNode randomNode = null;
        int count = 1;
        for (ListNode node = this.node; node != null; node = node.next, count++) {
            if (random.nextInt(count) == 0) {
                randomNode = node;
            }
        }
        return randomNode.val;
    }
}
