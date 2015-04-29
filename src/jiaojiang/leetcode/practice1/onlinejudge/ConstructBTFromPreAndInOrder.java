package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 24, 2013 10:13:36 PM
 */
public class ConstructBTFromPreAndInOrder {
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int breakPoint = 0;
        for (; breakPoint < inEnd && inorder[inStart + breakPoint] != preorder[preStart]; breakPoint++);

        root.left = buildTree(preorder, preStart + 1, preStart + breakPoint + 1, inorder, inStart, inStart + breakPoint);
        root.right = buildTree(preorder, preStart + breakPoint + 1, preEnd, inorder, inStart + breakPoint + 1, inEnd);

        return root;
    }

    public static void test() {
        TreeNode.inOrder(buildTree(new int[]{1,2,4,5,3,7,8}, new int[]{4,2,5,1,7,3,8}));
    }

    public static void main(String[] args){
        test();
    }

}
