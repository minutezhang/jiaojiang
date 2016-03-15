package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class KthSmallestElementInABST {
    /*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ² k ² BST's total elements.

    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
    would you optimize the kthSmallest routine?

    Hint:

        Try to utilize the property of a BST.
        What if you could modify the BST node's structure?
        The optimal runtime complexity is O(height of BST).
     */

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                if (--k == 0) {
                    return node.val;
                }
                node = node.right;
            } else {
                stack.add(node);
                node = node.left;
            }

        }
        return 0;
    }
}
