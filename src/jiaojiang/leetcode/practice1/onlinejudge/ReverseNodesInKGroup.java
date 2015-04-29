package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 14, 2013 8:53:29 PM
 */
public class ReverseNodesInKGroup {
    /*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    You may not alter the values in the nodes, only nodes itself may be changed.

    Only constant memory is allowed.

     For example,
     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        int count = 1;
        while (node.next != null && count < k) {
            node = node.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        ListNode nextHead = reverseKGroup(node.next, k);
        node = head;
        for (count = 1; count < k; count++) {
            ListNode tmp = node.next;
            node.next = nextHead;
            nextHead = node;
            node = tmp;
        }
        node.next = nextHead;

        return node;
    }

    public static void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseKGroup(head, 3).print();
    }

    public static void main(String[] args) {
        test();
    }
}
