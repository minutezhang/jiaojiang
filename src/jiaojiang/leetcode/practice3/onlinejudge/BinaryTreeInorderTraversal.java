package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 9:44:58 AM
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
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }

        return ret;
    }
}
