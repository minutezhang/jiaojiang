package companies.facebook.glassdoor;

import utils.ListNode;

/**
 * @author: zhang
 * @since: Feb 5, 2014 9:37:45 PM
 */
public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode pre = null, node, nextNode;
        for (node = head; node != null; nextNode = node.next, node.next = pre, pre = node, node = nextNode);
        return pre; 
    }

    private static void test() {
        ListNode.print(reverse(ListNode.getSampleNode(10)));
        ListNode.print(reverse(ListNode.getSampleNode(1)));
        ListNode.print(reverse(ListNode.getSampleNode(0)));
    }

    public static void main(String[] args) {
        test();
    }
}
