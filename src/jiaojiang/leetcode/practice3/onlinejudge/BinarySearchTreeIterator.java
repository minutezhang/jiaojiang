package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: mizhang
 * @time: 2/10/15 11:35 PM
 */
public class BinarySearchTreeIterator {
    /*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.

    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static List<Integer> iterate(TreeNode treeNode) {
        BSTIterator iterator = new BSTIterator(treeNode);
        List<Integer> ret = new ArrayList<Integer>();

        while (iterator.hasNext()) {
            ret.add(iterator.next());
        }

        return ret;
    }

    private static class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode node;

        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            node = root;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty() || node != null;
        }

        /** @return the next smallest number */
        public int next() {
            while (!stack.isEmpty() || node != null) {
                if (node == null) {
                    TreeNode ret = stack.pop();
                    node = ret.right;
                    return ret.val;
                } else {
                    stack.push(node);
                    node = node.left;
                }
            }

            return Integer.MAX_VALUE;
        }
    }
}
