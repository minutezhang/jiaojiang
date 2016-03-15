package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class InvertBinaryTree {
    /*
    Invert a binary tree.

         4
       /   \
      2     7
     / \   / \
    1   3 6   9

    to

         4
       /   \
      7     2
     / \   / \
    9   6 3   1

    Trivia:
    This problem was inspired by this original tweet by Max Howell:
        Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a
        whiteboard so fuck off.
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }

        return root;
    }
}
