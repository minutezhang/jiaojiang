package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
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
        binaryTreePaths(root, "", ret, "");

        return ret;
    }

    private static void binaryTreePaths(TreeNode node, String pathPrefix, List<String> ret, String delimiter) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            ret.add(pathPrefix + delimiter + node.val);
            return;
        }

        binaryTreePaths(node.left, pathPrefix + delimiter + node.val, ret, "->");
        binaryTreePaths(node.right, pathPrefix + delimiter + node.val, ret, "->");
    }
}
