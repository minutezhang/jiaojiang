package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 22, 2013 9:51:52 PM
 */
public class RemoveDuplicatesFromSortedList {
    /*
     Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        while (node != null) {
            ListNode n = node;
            while (n.next != null && n.next.val == node.val) {
                n = n.next;
            }
            node.next = n.next;
            node = node.next;
        }

        return head;
    }
}
