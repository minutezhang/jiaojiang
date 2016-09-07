package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang@akamai.com
 */
public class FlattenBT2LinkedList {
    /*
    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
     */
    public static void flatten(TreeNode root) {
        flatten(root, new TreeNode(0));
        TreeNode node = root;

        while (node != null) {
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }

    public static TreeNode flatten(TreeNode root, TreeNode preNode) {
        if (root == null) {
            return preNode;
        }

        preNode.left = root;
        TreeNode node = flatten(root.left, root);
        return flatten(root.right, node);
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        flatten(root);

        System.out.println(root.val);
        System.out.println(root.left);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
    }

    public static void main(String[] args) {
        test();
    }
}
