package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author: zhang
 * @date: Feb 21, 2015 6:14:15 PM
 */
public class RecoverBinarySearchTree {
    /*
     Two elements of a binary search tree (BST) are swapped by mistake.

    Recover the tree without changing its structure.
    Note:
    A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

    OJ's Binary Tree Serialization:

    The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

    Here's an example:

       1
      / \
     2   3
        /
       4
        \
         5

    The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
     */
    public static void recoverTree(TreeNode root) {
        TreeNode node1 = null, node2 = null, preNode = null, node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (preNode != null && preNode.val > node.val) {
                    if (node1 == null) {
                        node1 = preNode;
                    }
                    node2 = node;
                }
                preNode = node;
                node = node.right;
            }
        }

        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
