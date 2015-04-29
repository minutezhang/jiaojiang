package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class AddTwoNumbers {
    /*
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
     */
    public static ListNode getListNode(int i) {
        ListNode head = new ListNode(i % 10);
        i = i / 10;
        ListNode current = head;
        while (i != 0) {
            ListNode next = new ListNode(i % 10);
            current.next = next;
            current = next;
            i = i / 10;
        }

        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrier = 0, sum = l1.val + l2.val;
        if (sum >= 10) {
            carrier = 1;
            sum %= 10;
        }
        ListNode head = new ListNode(sum), currentSum = head, next1 = l1.next, next2 = l2.next, current = null;
        while (next1 != null && next2 != null) {
            sum = next1.val + next2.val + carrier;
            carrier = 0;
            if (sum >= 10) {
                carrier = 1;
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            currentSum.next = node;
            currentSum = node;
            next1 = next1.next;
            next2 = next2.next;
        }

        if (next1 == null) {
            current = next2;
        } else {
            current = next1;
        }

        while (current != null) {
            sum = current.val + carrier;
            carrier = 0;
            if (sum >= 10) {
                carrier = 1;
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            currentSum.next = node;
            currentSum = node;
            current = current.next;
        }

        if (carrier == 1) {
            currentSum.next = new ListNode(1); 
        }

        return head;
    }

    public static void main(String[] args) {
        addTwoNumbers(getListNode(68), getListNode(946)).print();

    }
}
