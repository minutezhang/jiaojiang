package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: zhang
 * @date: Apr 26, 2015 9:56:57 PM
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */
    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private static TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (iend == istart) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pend - 1]);
        int split;
        for (split = istart; split < iend && inorder[split] != postorder[pend - 1]; split++);
        root.left = buildTree(inorder, istart, split, postorder, pstart, pstart + split - istart);
        root.right = buildTree(inorder, split + 1, iend, postorder, pstart + split - istart, pend - 1);

        return root;
    }
}
