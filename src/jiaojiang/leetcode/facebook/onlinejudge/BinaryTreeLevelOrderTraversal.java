package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhang
 *
 * Created on Aug 31, 2016
 */
public class BinaryTreeLevelOrderTraversal {
    /*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by
    level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                ret.add(list);
                if (!queue.isEmpty()) {
                    queue.add(null);
                    list = new ArrayList<Integer>();
                }
            } else {
                list.add(node.val);
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
