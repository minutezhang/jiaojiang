package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Mar 11, 2016
 */
public class CountCompleteTreeNode {
    /*
    Given a complete binary tree, count the number of nodes.

    Definition of a complete binary tree from Wikipedia: https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
    level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
     */
    public static int countNodes(TreeNode root) {
        int leftHeight = 0, rightHeight = 0;
        for (TreeNode node = root; node != null; node = node.left, leftHeight++);
        for (TreeNode node = root; node != null; node = node.right, rightHeight++);
        
        return countNodes(root, leftHeight, rightHeight);
    }

    private static int countNodes(TreeNode root, int leftHeight, int rightHeight) {
        if (root == null) {
            return 0;
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        int leftNewHeight = 1, rightNewHeight = 1;
        //root.left is not null
        for (TreeNode node = root.left; node != null; node = node.right, leftNewHeight++);
        for (TreeNode node = root.right; node != null; node = node.left, rightNewHeight++);

        if (leftNewHeight == leftHeight) {
            return (1 << leftHeight - 1) + countNodes(root.right, rightNewHeight - 1, rightHeight - 1);
        }

        return (1 << rightHeight - 1) + countNodes(root.left, leftHeight - 1, leftNewHeight - 1);
    }
}
