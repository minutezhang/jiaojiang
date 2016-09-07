package jiaojiang.leetcode.practice1.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang@akamai.com
 */
public class ReverseLinkedListII {
    /*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ? m ? n ? length of list.
     */

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode node = fakeHead;
        int i = 1;
        while (node != null && i < m) {
            node = node.next;
            i++;
        }

        ListNode newHead = node.next, preNode = node;
        node = node.next;
        while (node.next != null && i < n) {
            ListNode tmpNode = node.next;
            node.next = node.next.next;
            tmpNode.next = newHead;
            newHead = tmpNode;
            i++;
        }

        preNode.next = newHead;

        return fakeHead.next;
    }

//    public static ListNode reverseBetween(ListNode head, int n) {
//        if (head == null || head.next == null || n < 1) {
//            return head;
//        }
//
//        ListNode node = reverseBetween(head.next, n - 1);
//
//    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public static void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode.print(head);

        ListNode.print(reverseBetween(head, 1, 3));
    }

    public static void main(String[] args) {
        test();
    }
}
