package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @date: Apr 26, 2015 10:05:32 AM
 */
public class BinaryTreeLevelOrderTraversalII {
    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7

    return its bottom-up level order traversal as:

    [
      [15,7],
      [9,20],
      [3]
    ]
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) {
            queue.add(root);
            queue.add(null);
        }

        List<Integer> nodes = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node == null) {
                ret.add(0, nodes);
                if (!queue.isEmpty()) {
                    queue.add(null);
                    nodes = new ArrayList<Integer>();
                }
            } else {
                nodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ret;
    }
}
