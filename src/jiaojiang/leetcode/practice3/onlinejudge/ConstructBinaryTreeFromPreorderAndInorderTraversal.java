package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @time: 2/6/15 11:26 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */

//             1
//            / \
//          2   5
//        / \   \
//      3   4   6

//    1, 2, 3, 4, 5, 6,
//    3, 2, 4, 1, 5, 6,
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart == pend) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[pstart]);
        int rootNodeIndex;
        for (rootNodeIndex = istart; rootNodeIndex < iend && inorder[rootNodeIndex] != preorder[pstart]; rootNodeIndex++);
        rootNode.left = buildTree(preorder, pstart + 1, pstart + rootNodeIndex - istart + 1, inorder, istart, rootNodeIndex);
        rootNode.right = buildTree(preorder, pstart + rootNodeIndex - istart + 1, pend, inorder, rootNodeIndex + 1, iend);

        return rootNode;
    }
}
