package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @since: Apr 25, 2013 11:06:19 AM
 */
public class BTMaxPathSum {
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
        return maxPathSumHelp(root)[0];
    }

    public static int[] maxPathSumHelp(TreeNode root) {
        int[] sums = new int[]{Integer.MIN_VALUE, 0};

        if (root == null) {
            return sums;
        }

        int[] leftSum = maxPathSumHelp(root.left);
        int[] rightSum = maxPathSumHelp(root.right);

        sums[0] = Math.max(Math.max(leftSum[0], rightSum[0]), root.val + leftSum[1] + rightSum[1]);
        sums[1] = Math.max(0, root.val + Math.max(leftSum[1], rightSum[1]));

        return sums;
    }
    
    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        return root;
    }


    public static void test() {
        System.out.println(maxPathSum(constructTree()));
        System.out.println(maxPathSum(new TreeNode(-3)));
        System.out.println(maxPathSum(new TreeNode(3)));
    }

    public static void main(String[] args) {
        test();
    }
}
