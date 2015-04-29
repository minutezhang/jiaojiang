package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 28, 2013 11:41:37 PM
 */
public class PartitionList {
    /*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0), greatHead = new ListNode(9);
        ListNode lessNode = lessHead, greatNode = greatHead, node = head;

        while (node != null) {
            if (node.val < x) {
                lessNode.next = node;
                lessNode = node;
            } else {
                greatNode.next = node;
                greatNode = node;
            }
            node = node.next;
        }

        lessNode.next = greatHead.next;
        greatNode.next = null;

        return lessHead.next;
    }

    public static void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        partition(head, 3).print();
    }

    public static void main(String[] args) {
        test();
    }
}
