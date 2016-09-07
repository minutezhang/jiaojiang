package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 8:17:26 AM
 */
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;

     public TreeNode(int x) {
         val = x;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    public static TreeNode getSampleTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        return root;
    }

    /*
             1
            / \
           2   5
          /
         3
        /
       4
      /
     6
     */
    public static TreeNode getSampleTree2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(6);

        return root;
    }

    /*
         10
        / \
       5   15
          /  \
         6   20
    */
    public static TreeNode getSampleTree3() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        return root;
    }

    /*
         10
        / \
       5   15
          /  \
         -6   -20
    */
    public static TreeNode getSampleTree4() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(-20);

        return root;
    }

    /*
           1
         /
        2

    */
    public static TreeNode getSampleTree5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        return root;
    }


    /*
             8
          /      \
         4       19
        / \     /  \
       3   6   11  20
            \   \
            7   14
     */
    public static TreeNode getSampleBinarySearchTree() {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);


        root.left.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(14);

        return root;
    }

    /*
                   5
              /          \
             3           10
          /     \      /     \
         2       4     8     10
               /     /   \
              3     5    8
                          \
                           9
                          /
                         8
     */


    public static TreeNode getSampleBinarySearchTree2() {
        TreeNode bst = new TreeNode(5);

        bst.left = new TreeNode(3);
        bst.right = new TreeNode(10);

        bst.left.left = new TreeNode(2);
        bst.left.right = new TreeNode(4);
        bst.right.left = new TreeNode(8);
        bst.right.right = new TreeNode(10);

        bst.left.right.left = new TreeNode(3);
        bst.right.left.left = new TreeNode(5);
        bst.right.left.right = new TreeNode(8);

        bst.right.left.right.right = new TreeNode(9);

        bst.right.left.right.right.left = new TreeNode(8);
        
        return bst;
    }

    /*
                      10
                   /    \
                 5       16
               /   \    /  \
             4     8  13   18
            /     /       / \
           3     7      17  19
     */
    public static TreeNode getSampleBinarySearchTree3() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(16);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        root.left.left.left = new TreeNode(3);
        root.left.right.left = new TreeNode(7);

        root.right.right.left = new TreeNode(17);
        root.right.right.right = new TreeNode(19);

        return root;
    }

    /*
                         1
                      /     \
                    2        2
                   /  \     / \
                 3    4   4    3


     */
    public static TreeNode getSampleSymmetricTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }

    public static TreeNode getSampleSymmetricTree2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(3);

        return root;
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    public void inOrder() {
        inOrder(this);
        System.out.println();
    }


    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder() {
        preOrder(this);
        System.out.println();
    }

    @Override
    public int hashCode() {
        return Integer.toString(val).hashCode();
    }

    @Override
    public boolean equals(Object anotherNode) {
        return this.getClass() == anotherNode.getClass() && equals(this, (TreeNode)anotherNode);
    }

    public static boolean equals(TreeNode root, TreeNode anotherRoot) {
        if (root == null && anotherRoot == null) {
            return true;
        }

        if (root == null || anotherRoot == null) {
            return false;
        }

        return root.val == anotherRoot.val && equals(root.left, anotherRoot.left) && equals(root.right, anotherRoot.right);
    }

    //Return whether two trees are same regardless its order, i.e., a.left == b.right && a.right == b.left is OK as well a.left == b.left && as a.right == b.right
    public static boolean isSameTreeRegardsOrder(TreeNode root, TreeNode root2) {
        if (root == null && root2 == null) {
            return true;
        }

        if (root == null || root2 == null) {
            return false;
        }

        return root.val == root2.val
                && (isSameTreeRegardsOrder(root.left, root2.left) && isSameTreeRegardsOrder(root.right, root2.right)
                        || isSameTreeRegardsOrder(root.left, root2.right) && isSameTreeRegardsOrder(root.right, root2.left));
    }

    public static boolean isBinarySearchTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root, preNode = null;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                if (preNode != null && preNode.val >= node.val) {
                    return false;
                }
                preNode = node;
                node = node.right;
            } else {
                stack.add(node);
                node = node.left;
            }
        }

        return true;
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            } else {
                stack.add(node);
                node = node.left;
            }
        }

        return ret;
    }



    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isHeightBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public static void main(String[] args) {
        getSampleTree().inOrder();
        getSampleBinarySearchTree().inOrder();
    }
}
