package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: zhang
 * @date: Feb 28, 2015 9:11:20 PM
 */
public class SumRootToLeafNumbers {
    /*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    For example,

        1
       / \
      2   3

    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
     */
    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode node, int prefix) {
        if (node == null) {
            return 0;
        }

        int currentValue = prefix * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentValue;
        }

        return sumNumbers(node.left, currentValue) + sumNumbers(node.right, currentValue);
    }
}
