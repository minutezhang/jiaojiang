package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class BinarySearchTreeIterator {
    /*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.

    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
     */

    private TreeNode nextTreeNode = null;
    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        nextTreeNode = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || nextTreeNode != null;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret;
        while (!stack.isEmpty() || nextTreeNode != null) {
            if (nextTreeNode != null) {
                stack.add(nextTreeNode);
                nextTreeNode = nextTreeNode.left;
            } else {
                ret = stack.pop();
                nextTreeNode = ret.right;
                return ret.val;
            }
        }
        throw new NoSuchElementException("");
    }

    public static List<Integer> iterate(TreeNode treeNode) {
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(treeNode);
        List<Integer> ret = new ArrayList<Integer>();

        while (iterator.hasNext()) {
            ret.add(iterator.next());
        }

        return ret;
    }
}
