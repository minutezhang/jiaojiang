package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: mizhang
 * @since: May 6, 2013 10:36:41 AM
 */
public class SymmtricTree {
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
         if (root == null) {
             return true;
         }

         return isSymmetric(root.left, root.right);
     }

    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null & root2 != null) {
            return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }

        return false;
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }

    public static boolean isSymmetric2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            if  (root1.val != root2.val) {
                return false;
            }

            Queue<TreeNode> left = new LinkedList<TreeNode>();
            Queue<TreeNode> right = new LinkedList<TreeNode>();

            left.add(root1);
            right.add(root2);

            while (!left.isEmpty() && !right.isEmpty()) {
                TreeNode leftNode = left.remove(), rightNode = right.remove();

                if (leftNode.left != null && rightNode.right != null) {
                    if (leftNode.left.val != rightNode.right.val) {
                        return false;
                    }
                    left.add(leftNode.left);
                    right.add(rightNode.right);
                } else if (leftNode.left != rightNode.right) {
                    return false;
                }

                if (leftNode.right != null && rightNode.left != null) {
                    if (leftNode.right.val != rightNode.left.val) {
                        return false;
                    }
                    left.add(leftNode.right);
                    right.add(rightNode.left);
                } else if (leftNode.right != rightNode.left) {
                    return false;
                }
            }

            return left.isEmpty() && right.isEmpty();
        }
        
        return false;
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));

        root.left = null;
        root.right = new TreeNode(2);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));

        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }

    public static void main(String[] args) {
        test();
    }
}
