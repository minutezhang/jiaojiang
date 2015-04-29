package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhang
 * @since: May 21, 2013 10:41:56 PM
 */
public class BinaryTreeInorderTraversal {
    /*
    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        TreeNode node = root;
        while (!stack.isEmpty()) {
            if (node.left != null) {
                stack.add(node = node.left);
            } else {
                TreeNode currentNode = stack.pop(); 
                ret.add(currentNode.val);
                if (currentNode.right != null) {
                    stack.add(node = currentNode.right);
                }
            }
        }

        return ret;
    }

    public static ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node = node.left);
            } else {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }

        return ret;
    }

    public static void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        for (int i : inorderTraversal(root)) {
            System.out.print(i + " ");
        }
        
        System.out.println("");

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        for (int i : inorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }

    public static void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        for (int i : inorderTraversal2(root)) {
            System.out.print(i + " ");
        }

        System.out.println("");

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        for (int i : inorderTraversal2(root)) {
            System.out.print(i + " ");
        }
    }


    public static void main(String[] args) {
        test();
    }
}
