package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @time: 3/6/15 5:23 PM
 */
public class BinaryTreeMaximumPathSum {
    /*
    Given a binary tree, find the maximum path sum.

    The path may start and end at any node in the tree.

    For example:
    Given the below binary tree,

           1
          / \
         2   3
    Return 6.
     */
    public static int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root)[1];
    }

    private static int[] maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        int[] left = maxPathSumHelper(node.left);
        int[] right = maxPathSumHelper(node.right);

        return new int[]{Math.max(0, Math.max(left[0], right[0])) + node.val, Math.max(Math.max(left[1], right[1]), Math.max(left[0], 0) + Math.max(0, right[0]) + node.val)};
    }
}
