package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: mizhang
 * @time: 3/6/15 6:27 PM
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue[] = new LinkedList[]{new LinkedList<TreeNode>(), new LinkedList<TreeNode>()};
        if (root != null) {
            queue[0].add(root);
        }

        for (int level = 0; !queue[level & 1].isEmpty() || !queue[(level + 1) & 1].isEmpty(); level++) {
            List<Integer> levelList = new ArrayList<Integer>();
            while (!queue[level & 1].isEmpty()) {
                TreeNode node = queue[level & 1].remove();
                levelList.add(node.val);
                if (node.left != null) {
                    queue[(level + 1) & 1].add(node.left);
                }
                if (node.right != null) {
                    queue[(level + 1) & 1].add(node.right);
                }
            }
            ret.add(levelList);
        }

        return ret;
    }
}
