package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @since: Dec 12, 2014 5:00:41 PM
 */
public class InsertionSortList {
    /*
    Sort a linked list using insertion sort.
     */
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0), nextNode;
        
        for(ListNode node = head; node != null; node = nextNode) {
            ListNode node2;
            nextNode = node.next;
            for (node2 = dummyHead; node2.next != null && node.val > node2.next.val; node2 = node2.next);
            node.next = node2.next;
            node2.next = node;
        }

        return dummyHead.next;
    }

    public static void test() {
        ListNode.print(ListNode.getSampleNode());
        ListNode.print(insertionSortList(ListNode.getSampleNode()));
    }

    public static void main(String[] args) {
        test();
    }

}
