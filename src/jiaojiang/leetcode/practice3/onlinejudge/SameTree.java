package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @time: 2/2/15 9:53 PM
 */
public class SameTree {
    /*
    Given two binary trees, write a function to check if they are equal or not.

    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        return (p == null || q == null) && p == q || p != null && q!= null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
