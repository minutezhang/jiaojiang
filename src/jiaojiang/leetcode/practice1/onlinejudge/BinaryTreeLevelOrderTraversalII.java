package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: mizhang
 * @since: Oct 9, 2013 4:04:23 PM
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
      [15,7]
      [9,20],
      [3],
    ]
     */
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            while (! q.isEmpty()) {
                TreeNode node = q.remove();

                values.add(node.val);

                if (node.left != null) {
                    q2.add(node.left);
                }

                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            Queue<TreeNode> ref = q2;
            q2 = q;
            q = ref;
            ret.add(values);
        }

        for (int i = 0, n = ret.size(); i < n / 2; i++) {
            ArrayList<Integer> tmp = ret.get(i);
            ret.set(i, ret.get(n - i - 1));
            ret.set(n - i - 1, tmp);
        }

        return ret;
    }
}
