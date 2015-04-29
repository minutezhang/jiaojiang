package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;
import utils.Test;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 4:13:19 PM
 */
public class LinkedListCycle {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
     */
    public static boolean hasCycle(ListNode head) {

        ListNode node = head;
        ListNode node2 = head;

        while (node2 != null && node2.next != null) {
            node2 = node2.next.next;
            node = node.next;
            if (node == node2) {
                return true;
            }
        }
        return false;
    }

    public static void test() {
        Test.assertTrue(hasCycle(ListNode.getSampleNodeWithCycle()));
        Test.assertTrue(!hasCycle(ListNode.getSampleNode()));
    }

    public static void main(String[] args) {
        test();
    }
}
