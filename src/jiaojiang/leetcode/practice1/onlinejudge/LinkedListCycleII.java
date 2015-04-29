package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Oct 31, 2013 2:52:06 PM
 */
public class LinkedListCycleII {
    /*
     Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Follow up:
    Can you solve it without using extra space?
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode next = head, nextNext = head;

        while (nextNext != null && nextNext.next != null) {
            next = next.next;
            nextNext = nextNext.next.next;
            if (next == nextNext) {
                break;
            }
        }

        if (nextNext == null || nextNext.next == null) {
            return null;
        }

        next = head;
        while (next != nextNext) {
            next = next.next;
            nextNext = nextNext.next;
        }
        return next;
    }

    private static void test() {
        Utils.printTestln(detectCycle(LinkedListCycle.constructCycle()).val, 1);
    }

    public static void main(String[] args) {
        test();
    }
}
