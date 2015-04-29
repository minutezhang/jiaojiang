package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @time: 3/3/15 11:09 AM
 */
public class AddTwoNumbers {
    /*
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
    each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), preNode = dummyHead;
        int carrier = 0;
        while ( l1 != null || l2 != null) {
            int a1 = 0,a2 = 0;
            if (l1 != null) {
                a1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                a2 = l2.val;
                l2 = l2.next;
            }

            int sum = a1 + a2 + carrier;
            if (sum > 9) {
                sum %= 10;
                carrier = 1;
            } else {
                carrier = 0;
            }
            preNode.next = new ListNode(sum);
            preNode = preNode.next;
        }

        if (carrier != 0) {
            preNode.next = new ListNode(carrier);
        }

        return dummyHead.next;
    }
}
