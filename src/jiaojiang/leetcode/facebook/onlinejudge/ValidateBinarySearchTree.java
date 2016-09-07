package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class ValidateBinarySearchTree {
    /*
     Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.

    Example 1:

        2
       / \
      1   3

    Binary tree [2,1,3], return true.

    Example 2:

        1
       / \
      2   3

    Binary tree [1,2,3], return false.
     */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        boolean isFirstNode = false;
        int prev = 0;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (isFirstNode && node.val <= prev) {
                    return false;
                }
                prev = node.val;
                isFirstNode = true;
                node = node.right;
            }
        }

        return true;
    }
}
