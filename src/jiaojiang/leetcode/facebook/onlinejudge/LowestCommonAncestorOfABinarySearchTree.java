package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /*
     Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: ÒThe lowest common ancestor is defined between two nodes v and w
    as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).Ó

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
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
