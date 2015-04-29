package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @time: 1/30/15 9:25 PM
 */
public class MaximumDepthOfBinaryTree {
    /*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root root down to the farthest leaf root.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
