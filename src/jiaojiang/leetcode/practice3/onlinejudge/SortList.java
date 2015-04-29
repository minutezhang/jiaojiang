package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @since: Dec 1, 2014 9:52:12 PM
 */
public class SortList {
    /*
    Sort a linked list in O(n log n) time using constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head, node2 = head.next;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        node2 = node1.next;
        node1.next = null;

        return merge(sortList(head), sortList(node2));
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node1 = head1, node2 = head2, node = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }

        if (node1 == null) {
            node.next = node2;
        } else {
            node.next = node1;
        }

        return dummyHead.next;
    }

    public static void test() {
        ListNode node = ListNode.getSampleNode();
        ListNode.print(node);

        ListNode.print(sortList(node));
    }

    public static void main(String[] args) {
        test();
    }

}
