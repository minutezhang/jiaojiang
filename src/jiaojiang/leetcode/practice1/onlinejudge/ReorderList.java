package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Nov 5, 2013 10:13:55 PM
 */
public class ReorderList {
    /*
    Given a singly linked list L: L0?L1?�?Ln-1?Ln,
    reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?�

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public static void reorderList(ListNode head) {
        ListNode node  = split(head);

        if (node == null) {
            return;
        }

        ListNode half = reverse(node.next);
        node.next = null;
        merge(head, half);
    }

    //head2 list is always not longer than head1
    private static void merge(ListNode head1, ListNode head2) {
        ListNode node1 = head1, node2 = head2;
        while (node1 != null && node2 != null) {
            ListNode next1 = node1.next, next2 = node2.next;
            node1.next = node2;
            node2.next = next1;
            node1 = next1;
            node2 = next2;
        }
    }

    private static ListNode split(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head, node2 = head;

        while (node2.next != null) {
            if (node2.next.next == null) {
                return node.next;
            }
            node2 = node2.next.next;
            node = node.next;
        }

        return node;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head, nextNode = node.next;
        node.next = null;

        while (nextNode != null) {
            ListNode tmp = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = tmp;
        }
        
        return node;
    }

    private static void test() {
        ListNode head = ListNode.constructList(10);
        head.print();

        reorderList(head);
        head.print();
    }

    public static void main(String[] args){
        test();
    }
}
