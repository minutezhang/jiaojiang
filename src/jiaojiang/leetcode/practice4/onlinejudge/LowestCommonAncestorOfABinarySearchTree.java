package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /*
     Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: ÒThe lowest common ancestor is defined between two nodes v and w as
    the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).Ó

            _______6______
           /              \
        ___2__          ___8__
       /      \        /      \
       0      _4       7       9
             /  \
             3   5

    For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
    since a node can be a descendant of itself according to the LCA definition.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (root.val == p.val || root.val == q.val || root.val > p.val && root.val < q.val) {
            return root;
        }


        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return lowestCommonAncestor(root.left, p, q);
    }
}
