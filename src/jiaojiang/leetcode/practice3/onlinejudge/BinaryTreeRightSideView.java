package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @date: Apr 26, 2015 12:36:41 AM
 */
public class BinaryTreeRightSideView {
    /*
    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    For example:
    Given the following binary tree,

       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---

    You should return [1, 3, 4].
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        int preInt = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                ret.add(preInt);
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                addToQueue(node.left, queue);
                addToQueue(node.right, queue);
                preInt = node.val;
            }
        }

        return ret;
    }

    private static void addToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) {
            queue.add(node);
        }
    }
}
