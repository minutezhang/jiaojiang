package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: Apr 23, 2013 10:21:08 PM
 */
public class BinaryTreeLevelOrderTraversal {
    /*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},

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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                values.add(node.val);
                if (node.left != null) {
                    queue2.add(node.left);
                }

                if (node.right != null) {
                    queue2.add(node.right);
                }
            }

            ret.add(values);
            Queue<TreeNode> tmpRef = queue2;
            queue2 = queue;
            queue = tmpRef;
        }

        return ret;
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        for (ArrayList<Integer> list : levelOrder(root)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
