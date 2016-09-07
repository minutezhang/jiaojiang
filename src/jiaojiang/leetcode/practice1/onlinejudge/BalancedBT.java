package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang@akamai.com
 */
public class BalancedBT {
    /*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     */
    public static boolean isBalanced(TreeNode root) {
        return isBalanced(root, 0) != -1;
    }

    public static int isBalanced(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        }

        if (root.left == null && root.right == null) {
            return currentDepth + 1;
        }

        int leftDepth = isBalanced(root.left, currentDepth + 1);
        int rightDepth = isBalanced(root.right, currentDepth + 1);

        if (leftDepth == -1 || rightDepth == -1 || rightDepth - leftDepth < -1 || rightDepth - leftDepth > 1) {
            return -1;
        }

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
