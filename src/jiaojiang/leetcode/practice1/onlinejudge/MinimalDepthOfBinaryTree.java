package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;
import utils.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: Apr 23, 2013 9:47:46 PM
 */
public class MinimalDepthOfBinaryTree {
    /*
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                depth++;
                queue.add(null);
            } else if (node.left == null && node.right == null) {
                return depth;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }

    public static int minDepth2(TreeNode root) {
        return minDepth2(root, 0);
    }

    public static int minDepth2(TreeNode root, int i) {
        if(root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return i + 1;
        }

        if (root.left == null) {
            return minDepth2(root.right, i + 1);
        }

        if (root.right == null) {
            return minDepth2(root.left, i + 1);
        }

        return Math.min(minDepth2(root.left, i + 1), minDepth2(root.right,  i + 1));
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        Utils.printTestln(minDepth(root), 3);
        Utils.printTestln(minDepth2(root), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
