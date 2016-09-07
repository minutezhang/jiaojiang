package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class BinaryTreeVerticalOrderTraversal {
    /*
    Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column
    by column).

    If two nodes are in the same row and column, the order should be from left to right.

    Examples:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its vertical order traversal as:

    [
      [9],
      [3,15],
      [20],
      [7]
    ]

    Given binary tree [3,9,20,4,5,2,7],

        _3_
       /   \
      9    20
     / \   / \
    4   5 2   7

    return its vertical order traversal as:

    [
      [4],
      [9],
      [3,5,2],
      [20],
      [7]
     */
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        verticalOrder(root, 0, map);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ret.add(entry.getValue());
        }

        return ret;
    }

    private static void verticalOrder(TreeNode root, int offset, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        List<Integer> list = map.get(offset);
        if (list == null) {
            list = new ArrayList<Integer>();
            map.put(offset, list);
        }
        list.add(root.val);
        verticalOrder(root.left, offset - 1, map);
        verticalOrder(root.right, offset + 1, map);
    }
}
