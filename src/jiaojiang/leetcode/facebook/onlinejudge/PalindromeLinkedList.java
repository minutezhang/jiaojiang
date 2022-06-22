package jiaojiang.leetcode.facebook.onlinejudge;

import utils.ListNode;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class PalindromeLinkedList {
    /*
    Given a singly linked list, determine if it is a palindrome.

    Follow up:
    Could you do it in O(n) time and O(1) space?
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode node, node2;
        for (node = head, node2 = head.next; node2 != null && node2.next != null; node = node.next, node2 = node2.next.next){};

        ListNode newHead = reverse(node.next);
        node.next = null;
        for (ListNode n = head, n2 = newHead; n != null && n2 != null; n = n.next, n2 = n2.next) {
            if (n.val != n2.val) {
                node.next = reverse(newHead);
                return false;
            }
        }

        node.next = reverse(newHead);
        return true;
    }

    private static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
