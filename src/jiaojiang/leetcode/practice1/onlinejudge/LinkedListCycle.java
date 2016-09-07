package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;
import utils.ListNode;

/**
 * @author: mizhang
 * @since: Oct 31, 2013 11:31:21 AM
 */
public class LinkedListCycle {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
     */
    public static boolean hasCycle(ListNode head) {
        ListNode next = head, nextNext = head;

        while (nextNext != null && nextNext.next != null) {
            next = next.next;
            nextNext = nextNext.next.next;
            if (next == nextNext) {
                return true;
            }
        }

        return false;
    }

    protected static ListNode construct() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);

        head.next = node1;

        ListNode node = node1;
        for (int i = 2; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return head;
    }

    protected static ListNode constructCycle() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);

        head.next = node1;

        ListNode node = node1;
        for (int i = 2; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        node.next = node1;
        return head;
    }

    public static void test() {
        Utils.printTestln(hasCycle(constructCycle()), true);
        Utils.printTestln(hasCycle(construct()), false);
    }

    public static void main(String[] args) {
        test();
    }
}
