package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class ValidateBST {
    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     */

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            if (node.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            if (node.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        return root;
    }

    public static TreeNode constructTree2() {
        TreeNode root = new TreeNode(19);
        return root;
    }

    public static TreeNode constructTree3() {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        return root;
    }

    public static TreeNode constructTree4() {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        return root;
    }

    public static void test() {
        System.out.println(isValidBST(constructTree()));
        System.out.println(isValidBST(constructTree2()));
        System.out.println(isValidBST(constructTree3()));
        System.out.println(isValidBST(constructTree4()));
    }

    public static void main(String[] args) {
        test();
    }
}
