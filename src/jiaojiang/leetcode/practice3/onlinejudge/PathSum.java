package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;
import utils.TreeNode;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 4:55:29 PM
 */
public class PathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void test() {
        Test.assertTrue(hasPathSum(TreeNode.getSampleTree(), 5));
        Test.assertTrue(hasPathSum(TreeNode.getSampleTree(), 7));
        Test.assertTrue(!hasPathSum(TreeNode.getSampleTree(), 3));
    }

    public static void main(String[] args) {
        test();
    }
}
