package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.util.Stack;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 8:24:20 AM
 */
public class ValidateBinarySearchTree {
    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     */
    public static boolean isValidBST(TreeNode root) {
//        return root == null || isValidBST(root.left) && isValidBST(root.right) && (root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val);

        Integer[] pre = new Integer[]{null};
        return isValidBST(pre, root);
    }

    public static boolean isValidBST(Integer[] pre, TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(pre, root.left)) {
             return false;
        }

        if (pre[0] != null && pre[0] >= root.val) {
            return false;
        }
        pre[0] = root.val;

        return isValidBST(pre, root.right);
    }

    public static boolean isValidBST2(TreeNode root) {
        Integer pre = null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                if (pre != null && pre >= node.val){
                    return false;
                }
                pre = node.val;
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }

        return true;
    }

    public static void test() {
        Test.assertTrue(!isValidBST(TreeNode.getSampleTree()));
        Test.assertTrue(!isValidBST(TreeNode.getSampleTree2()));
        Test.assertTrue(isValidBST(TreeNode.getSampleBinarySearchTree()));

        Test.assertTrue(!isValidBST2(TreeNode.getSampleTree()));
        Test.assertTrue(!isValidBST2(TreeNode.getSampleTree2()));
        Test.assertTrue(isValidBST2(TreeNode.getSampleBinarySearchTree()));
    }

    public static void main(String[] args) {
        test();
    }
}
