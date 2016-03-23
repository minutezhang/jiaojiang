package jiaojiang.leetcode.practice4.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Mar 19, 2016
 */
public class BinaryTreePaths {
    /*
     Given a binary tree, return all root-to-leaf paths.

    For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5

    All root-to-leaf paths are:

    ["1->2->5", "1->3"]
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();

        binaryTreePaths(root, null, ret);

        return ret;
    }

    private static void binaryTreePaths(TreeNode root, String prefix, List<String> ret) {
        if (root == null) {
            return;
        }

        String newPrefix = prefix == null ? String.valueOf(root.val) : prefix + "->" + root.val;
        if (root.left == null && root.right == null) {
            ret.add(newPrefix);
            return;
        }

        binaryTreePaths(root.left, newPrefix, ret);
        binaryTreePaths(root.right, newPrefix, ret);
    }
}
