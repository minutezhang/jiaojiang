package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: mizhang
 * @since: Dec 3, 2014 5:04:32 PM
 */
public class SymmetricTree {
    /*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.
     */
    public static boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode root, TreeNode root2) {
        if (root == null || root2 == null) {
            return root == root2;
        }

        return root.val == root2.val && isSymmetric(root.left, root2.right) && isSymmetric(root.right, root2.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        return root == null ? true : isSymmetric2(root.left, root.right);
    }

    public static boolean isSymmetric2(TreeNode root, TreeNode root2) {
        if (root == null || root2 == null) {
            return root == root2;
        }

        if (root.val != root2.val) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q.add(root);
        q2.add(root2);

        while (!q.isEmpty() && !q2.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode node2 = q2.remove();

            if (node.left != null && node2.right != null) {
                q.add(node.left);
                q2.add(node2.right);
                if (node.left.val != node2.right.val) {
                    return false;
                }
            } else if (node.left != node2.right) {
                return false;
            }

            if (node.right != null && node2.left != null) {
                q.add(node.right);
                q2.add(node2.left);
                if (node.right.val != node2.left.val) {
                    return false;
                }
            } else if (node.right != node2.left) {
                return false;
            }
        }

        return q.isEmpty() && q2.isEmpty();
    }

    public static void test() {
        Test.assertTrue(!isSymmetric(TreeNode.getSampleTree()));
        Test.assertTrue(!isSymmetric(TreeNode.getSampleTree2()));
        Test.assertTrue(!isSymmetric(TreeNode.getSampleBinarySearchTree()));
        Test.assertTrue(isSymmetric(TreeNode.getSampleSymmetricTree()));
        Test.assertTrue(!isSymmetric(TreeNode.getSampleSymmetricTree2()));

        System.out.println();

        Test.assertTrue(!isSymmetric2(TreeNode.getSampleTree()));
        Test.assertTrue(!isSymmetric2(TreeNode.getSampleTree2()));
        Test.assertTrue(!isSymmetric2(TreeNode.getSampleBinarySearchTree()));
        Test.assertTrue(isSymmetric2(TreeNode.getSampleSymmetricTree()));
        Test.assertTrue(!isSymmetric2(TreeNode.getSampleSymmetricTree2()));
    }

    public static void main(String[] args) {
        test();
    }
}
