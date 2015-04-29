package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 1:10:57 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then
    right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
     */
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reversed = false;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (root == null) {
            return ret;
        }

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.add(root);

        List<Integer> list = new ArrayList<Integer>();
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            if (reversed) {
                if (node.right != null) {
                    s2.push(node.right);
                }
                if (node.left != null) {
                    s2.push(node.left);
                }
            } else {
                if (node.left != null) {
                    s2.push(node.left);
                }
                if (node.right != null) {
                    s2.push(node.right);
                }
            }
            list.add(node.val);

            if (s1.isEmpty()) {
                Stack<TreeNode> s = s2;
                s2 = s1;
                s1 = s;
                reversed = !reversed;
                ret.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return ret;
    }

    public static void test() {
        Test.printListList(zigzagLevelOrder(TreeNode.getSampleTree()));
        Test.printListList(zigzagLevelOrder(TreeNode.getSampleTree2()));
        Test.printListList(zigzagLevelOrder(TreeNode.getSampleBinarySearchTree()));
    }

    public static void main(String[] args) {
        test();
    }
    
}
