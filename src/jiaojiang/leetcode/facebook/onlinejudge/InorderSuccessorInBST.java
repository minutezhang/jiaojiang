package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class InorderSuccessorInBST {
    /*
    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

    Note: If the given node has no in-order successor in the tree, return null.
     */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        TreeNode ret = null;
        while (root != null) {
            if (root.val > p.val) {
                ret = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ret;
    }
}
