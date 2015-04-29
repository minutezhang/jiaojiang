package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 2/9/15 11:03 PM
 */
public class RemoveDuplicatesFromSortedList {
    /*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode, nextNode;
        for (currentNode = head, nextNode = head.next; nextNode != null; nextNode = nextNode.next) {
            if (nextNode.val != currentNode.val) {
                currentNode = currentNode.next = nextNode;
            }
        }

        currentNode.next = nextNode;

        return head;
    }
}
