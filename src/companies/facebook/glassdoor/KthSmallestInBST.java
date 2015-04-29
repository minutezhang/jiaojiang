package companies.facebook.glassdoor;

import jiaojiang.leetcode.practice2.onlinejudge.TreeNode;
import utils.Utils;

import java.util.Stack;

/**
 * @author: zhang
 * @since: Feb 7, 2014 9:03:37 PM
 */
public class KthSmallestInBST {
    /*
    Given a binary search tree, write an algorithm to find the kth smallest element
     */
    public static int kth(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                if (++count == k) {
                    return node.val;
                }
                node = node.right;
            } else {
                stack.add(node);
                node = node.left;
            }

        }
        
        return -1;
    }

    /*
             8
          /      \
         4       19
        / \     /  \
       3   6   11  20
            \   \
            7   14
     */
    private static void test() {
        Utils.printTestln(kth(TreeNode.getSampleBinarySearchTree(), 3), 6);
        Utils.printTestln(kth(TreeNode.getSampleBinarySearchTree(), 7), 14);
        Utils.printTestln(kth(TreeNode.getSampleBinarySearchTree(), 5), 8);
    }

    public static void main(String[] args) {
        test();
    }
}
