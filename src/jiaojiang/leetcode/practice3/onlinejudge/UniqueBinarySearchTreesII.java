package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/29/15 2:08 PM
 */
public class UniqueBinarySearchTreesII {
    /*
    Unique Binary Search Trees II Total Accepted: 23171 Total Submissions: 84621 My Submissions Question Solution
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */
    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    // both start and end are inclusive
    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new ArrayList<TreeNode>();

        if (start > end) {
            ret.add(null);
            return ret;
        }

        for (int i = start; i <= end; i++) {
            for (TreeNode leftTree : generateTrees(start, i - 1)) {
                for (TreeNode rightTree: generateTrees(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ret.add(root);
                }
            }
        }

        return ret;
    }
}