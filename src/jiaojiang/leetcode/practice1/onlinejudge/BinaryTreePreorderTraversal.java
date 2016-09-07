package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: mizhang
 * @since: Nov 6, 2013 2:52:32 PM
 */
public class BinaryTreePreorderTraversal {
    /*
    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            ret.add(node.val);
            node = node.left;
        }

        return ret;
    }

    public static void test() {
        Utils.printListln(preorderTraversal(TreeNode.getSampleTree()));
    }

    public static void main(String[] args) {
        test();
    }
}
