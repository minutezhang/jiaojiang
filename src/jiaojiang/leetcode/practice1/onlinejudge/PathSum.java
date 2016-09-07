package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.List;

/**
 * @author: mizhang@akamai.com
 */
public class PathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
//        return hasPathSum(root, new ArrayList<Integer>(), sum);
        return hasPathSum(root, 0, sum);
    }

    public static boolean hasPathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum + root.val == targetSum;
        }

        if (hasPathSum(root.left, sum + root.val, targetSum)) {
            return true;
        }

        if (hasPathSum(root.right, sum + root.val, targetSum)) {
            return true;
        }

        return false;
    }

    public static boolean hasPathSum(TreeNode root, List<Integer> list, int targetSum) {
        if (root == null) {
            return false;
        }

        list.add(root.val);

        if (root.left == null && root.right == null) {

            int sum = 0;
            for (int i : list) {
                sum += i;
            }

            list.remove(list.size() - 1);
            return sum == targetSum;
        }

        if (hasPathSum(root.left, list, targetSum)) {
            return true;
        }

        if (hasPathSum(root.right, list, targetSum)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }

    public static void test() {
        System.out.println(hasPathSum(getSampleTree(), 22));
        System.out.println(hasPathSum(getSampleTree2(), 6));
    }

    public static TreeNode getSampleTree() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        return root;
    }

    public static TreeNode getSampleTree2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.left.left.left = new TreeNode(4);

        root.left.left.left.left = new TreeNode(5);

        return root;
    }

    public static void main(String[] args) {
        test();
    }
}
