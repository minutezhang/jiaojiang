package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

/**
 * @author: zhang
 * @since: Apr 24, 2013 9:10:49 PM
 */
public class ConstructBTFromInAndPostOrder {
    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int breakPoint = 0;
        for (; breakPoint < inorder.length && inorder[breakPoint] != postorder[postorder.length - 1]; breakPoint++);
        int[] inOrder1 = new int[breakPoint], inOrder2 = new int[inorder.length - breakPoint - 1];
        int[] postOrder1 = new int[breakPoint], postOrder2 = new int[inorder.length - breakPoint - 1];
        System.arraycopy(inorder, 0, inOrder1, 0, breakPoint);
        System.arraycopy(inorder, breakPoint + 1, inOrder2, 0, inorder.length - breakPoint - 1);
        System.arraycopy(postorder, 0, postOrder1, 0, breakPoint);
        System.arraycopy(postorder, breakPoint, postOrder2, 0, inorder.length - breakPoint - 1);

        root.left = buildTree(inOrder1, postOrder1);
        root.right = buildTree(inOrder2, postOrder2);

        return root;
    }

    public static void test() {
        TreeNode.inOrder(buildTree(new int[]{4,2,5,1,7,3,8}, new int[]{4,5,2,7,8,3,1}));
    }

    public static void main(String[] args){
        test();
    }
}
