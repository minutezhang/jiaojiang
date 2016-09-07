package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 29, 2013 11:13:49 PM
 */
public class UniqueBSTsII {
    /*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */

    public static ArrayList<TreeNode> generateTrees(int n) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }

        return generateTrees(list, 0, n);
    }

    public static ArrayList<TreeNode> generateTrees(int[] list, int start, int end) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();

        if (start == end) {
            ret.add(null);
            return ret;
        }

        if (start == end - 1) {
            TreeNode node = new TreeNode(list[start]);
            ret.add(node);
            return ret;
        }

        for (int i = start; i < end; i++) {
            ArrayList<TreeNode> left = generateTrees(list, start, i);
            ArrayList<TreeNode> right = generateTrees(list, i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(list[i]);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }

        return ret;
    }

    public static void test() {
        for (TreeNode root : generateTrees(3)) {
            TreeNode.inOrder(root);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
