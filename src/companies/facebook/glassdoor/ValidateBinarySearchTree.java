package companies.facebook.glassdoor;

import jiaojiang.leetcode.practice2.onlinejudge.TreeNode;
import utils.Utils;

import java.util.Stack;

/**
 * @author: zhang
 * @since: Feb 5, 2014 9:16:54 PM
 */
public class ValidateBinarySearchTree {
    public static boolean isBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode node = root;
        int preValue = Integer.MIN_VALUE;
        boolean firstNodeVisited = false;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.add(node);
                node = node.left;
            } else {
                node = s.pop();
                if (!firstNodeVisited) {
                    preValue = node.val;
                    firstNodeVisited = true;
                } else if (node.val <= preValue) {
                    return false;
                }
                node = node.right;
            }
        }
        return true;
    }

    private static void test() {
        Utils.printTestln(isBST(TreeNode.getSampleTree()), false);
        Utils.printTestln(isBST(TreeNode.getSampleBinarySearchTree()), true);
    }

    public static void main(String[] args) {
        test();
    }
}
