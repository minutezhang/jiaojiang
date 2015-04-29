package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: mizhang@akamai.com
 */
public class MaxDepthOfBT {
    /*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q2.add(node.left);
                }

                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            depth++;
            Queue<TreeNode> ref = q2;
            q2 = q;
            q = ref;
        }

        return depth;
    }

    public static int maxDepth2(TreeNode root) {
        return maxDepth2(root, 0);
    }

    public static int maxDepth2(TreeNode root, int currentDepth) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return currentDepth + 1;
        }

        return Math.max(maxDepth2(root.left, currentDepth + 1), maxDepth2(root.right, currentDepth + 1));
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        return root;
    }


    public static void test() {
        System.out.println(maxDepth(new TreeNode(1)));
        System.out.println(maxDepth2(constructTree()));
    }

    public static void main(String[] args) {
        test();
    }

}
