package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;
import utils.Test;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 4:24:18 PM
 */
public class LinkedListCycleII {
    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Follow up:
    Can you solve it without using extra space?
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode node = head;
        ListNode node2 = head;
        boolean hasCycle = false;

        while (node2 != null && node2.next != null) {
            node = node.next;
            node2 = node2.next.next;
            if (node == node2) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            node = head;
            while (node != null && node != node2) {
                node = node.next;
                node2 = node2.next;
            }
            return node;
        }

        return null;
    }

    public static void test() {
        Test.assertEquals(3, detectCycle(ListNode.getSampleNodeWithCycle()).val);
    }

    public static void main(String[] args) {
        test();
    }
}
