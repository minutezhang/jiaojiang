package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;
import utils.ListNode;

import java.util.List;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 12, 2013 10:10:04 PM
 */
public class ConvertSortedListToBST {
    /*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public static TreeNode sortedListToBST(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }


        return sortedListToBST(Arrays.asList(head), 0, count - 1);
    }

    public static TreeNode sortedListToBST(List<ListNode> head, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >>> 1;

        TreeNode left = sortedListToBST(head, start, mid - 1);
        TreeNode root = new TreeNode(head.get(0).val);
        root.left = left;
        head.set(0, head.get(0).next);
        root.right = sortedListToBST(head, mid + 1, end);
        
        return root;
    }

    public static void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        TreeNode.inOrder(sortedListToBST(head));
    }

    public static void main(String[] args) {
        test();
    }
}
                           
