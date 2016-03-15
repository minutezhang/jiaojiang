package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class LowestCommonAncestorOfABinaryTree {
    /*
     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: ÒThe lowest common ancestor is defined between two nodes v and w as
    the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).Ó

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
        if (root == p || root == q) {
            return root;
        }

        boolean[] hasPQ = hasPQ(root.left, p, q);
        if (hasPQ[0] && hasPQ[1]) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (hasPQ[0] || hasPQ[1]) {
            return root;
        }

        return lowestCommonAncestor(root.right, p, q);
    }

    private static boolean[] hasPQ(TreeNode root, TreeNode p, TreeNode q) {
        boolean[] hasPQ = new boolean[2];

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                if (node == p) {
                    hasPQ[0] = true;
                } else if (node == q) {
                    hasPQ[1] = true;
                }

                if (hasPQ[0] && hasPQ[1]) {
                    return hasPQ;
                }
                
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }

        }
        return hasPQ;
    }
}
