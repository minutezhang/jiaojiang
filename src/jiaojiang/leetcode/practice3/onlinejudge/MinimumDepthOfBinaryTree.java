package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: zhang
 * @date: Feb 28, 2015 3:37:54 PM
 */
public class MinimumDepthOfBinaryTree {
    /*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
