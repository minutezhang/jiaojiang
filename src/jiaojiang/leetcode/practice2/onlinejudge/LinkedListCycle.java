package jiaojiang.leetcode.practice2.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @since: Jan 6, 2014 3:39:51 PM
 */
public class LinkedListCycle {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
    */
    public static boolean hasCycle(ListNode head) {
        ListNode one = head, two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;

            if (one == two) {
                return true;
            }
        }
        
        return false;
    }
}
