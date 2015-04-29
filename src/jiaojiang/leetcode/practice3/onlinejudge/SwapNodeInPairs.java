package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 2:49:32 PM
 */
public class SwapNodeInPairs {
    /*
    Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
                return head;
            }

        ListNode node  = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode node = head, dummyNode = new ListNode(0), preNode = dummyNode;

        while (node != null && node.next != null) {
            preNode.next = node.next;
            ListNode nextNode = node.next.next;
            preNode.next.next = node;
            preNode = node;
            node = nextNode;
        }

        preNode.next = node;
        
        return dummyNode.next;
    }

    public static void test() {
        ListNode.print(ListNode.getSampleNode());
        ListNode.print(swapPairs(ListNode.getSampleNode()));
        ListNode.print(swapPairs2(ListNode.getSampleNode()));
    }

    public static void main(String[] args) {
        test();
    }
}
