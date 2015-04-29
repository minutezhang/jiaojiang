package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: mizhang@akamai.com
 */
public class BTZigzagLevelOrderTraversal {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:

    [
      [3],
      [20,9],
      [15,7]
    ]
     */

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return ret;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s.add(root);
        boolean ordered = true;

        while (!s.isEmpty()) {
            ArrayList<Integer> values = new ArrayList<Integer>();

            while (!s.isEmpty()) {
                TreeNode node = s.pop();
                values.add(node.val);

                TreeNode[] nodes = ordered ? new TreeNode[] {node.left, node.right} : new TreeNode[] {node.right, node.left};
                for (TreeNode n : nodes) {
                    if (n != null) {
                        s2.add(n);
                    }
                }
            }
            ret.add(values);
            Stack<TreeNode> ref = s2;
            s2 = s;
            s = ref;
            ordered = !ordered;
        }

        return ret;
    }
}
