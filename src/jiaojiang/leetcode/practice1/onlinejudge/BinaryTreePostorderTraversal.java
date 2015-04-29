package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: mizhang
 * @since: Nov 8, 2013 2:20:44 PM
 */
public class BinaryTreePostorderTraversal {
    /*
    Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [3,2,1].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode preNode = root;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            // leaf node or both child nodes are visited
            if (node.left == null && node.right == null || (preNode == node.left || preNode == node.right)) {
                ret.add(node.val);
                preNode = stack.pop();
            } else {
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }

        return ret;
    }

    public static void test() {
        Utils.printListln(postorderTraversal(TreeNode.construct()));
    }

    public static void main(String[] args) {
        test();
    }
}
