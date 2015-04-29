package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: zhang
 * @date: Apr 23, 2015 10:30:42 PM
 */
public class RemoveLinkedListElements {
    /*
    Remove all elements from a linked list of integers that have value val.

    Example
    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0), node = dummyNode;

        for (; head != null; head = head.next) {
            if (head.val != val) {
                node = node.next = head;
            }
        }
        node.next = null;
        
        return dummyNode.next;
    }
}
