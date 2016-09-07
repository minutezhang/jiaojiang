package jiaojiang.leetcode.practice1.onlinejudge;

import utils.ListNode;

/**
 * @author: zhang
 * @since: Apr 14, 2013 1:47:00 AM
 */
public class SwapNodesInPair {
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

        ListNode newHead =  head.next;
        head.next =  swapPairs(newHead.next);
        newHead.next = head;

        return newHead;
    }

//test cases:
//{}
//
//{1}
//
//{1,2}
//
//{1,2,3}
//
//{1,2,3,4}
//
//{1,2,3,4,5}
//
//{4,8}
//
//{2,5,3,4,6,2,2}
}
