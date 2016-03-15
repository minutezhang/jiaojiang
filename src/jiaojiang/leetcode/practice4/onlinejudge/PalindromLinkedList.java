package jiaojiang.leetcode.practice4.onlinejudge;

import utils.ListNode;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class PalindromLinkedList {
    /*
    Given a singly linked list, determine if it is a palindrome.

    Follow up:
    Could you do it in O(n) time and O(1) space?
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null ) {
            return true;
        }

        ListNode node = head, node2 = head.next;
        for (; node2 != null && node2.next != null; node2 = node2.next.next, node = node.next);

        ListNode dummyHead = new ListNode(0);
        for(ListNode nextNode = node.next; nextNode != null; ) {
            ListNode tmpNode = nextNode.next;
            nextNode.next = dummyHead.next;
            dummyHead.next = nextNode;
            nextNode = tmpNode;
        }

        for (node = head, node2 = dummyHead.next; node != null && node2 != null; node = node.next, node2 = node2.next) {
            if (node.val != node2.val) {
                return false;
            }
        }

        return true;
    }
}
