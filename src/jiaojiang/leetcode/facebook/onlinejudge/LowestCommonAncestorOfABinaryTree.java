package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Sep 2, 2016
 */
public class LowestCommonAncestorOfABinaryTree {
    /*
     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: ÒThe lowest common ancestor is defined between two nodes v and w
    as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).Ó

            _______3______
           /              \
        ___5__          ___1__
       /      \        /      \
       6      _2       0       8
             /  \
             7   4

    For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
    since a node can be a descendant of itself according to the LCA definition.
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }

        return left;
    }


    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int leftCount = hasNode(root.left, p, q), rightCount = hasNode(root.right, p, q);

        if ( leftCount == 1 && rightCount == 1) {
            return root;
        }
        if (leftCount == 2) {
            return lowestCommonAncestor2(root.left, p, q);
        }

        if (rightCount == 2) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        if ((root == p || root == q) && (leftCount == 1 || rightCount == 1)) {
            return root;
        }

        return null;
    }

    private static int hasNode(TreeNode root, TreeNode child1, TreeNode child2) {
        if (root == null) {
            return 0;
        }
        
        if (root == child1 || root == child2) {
            return 1 + hasNode(root.left, child1, child2) + hasNode(root.right, child1,  child2);
        }

        return hasNode(root.left, child1, child2) + hasNode(root.right, child1,  child2);
    }
}
