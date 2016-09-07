package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

/**
 * @author: zhang
 * @since: Apr 22, 2013 10:20:22 PM
 */
public class SameTree {
    /*
     Given two binary trees, write a function to check if they are equal or not.

    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     */
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
