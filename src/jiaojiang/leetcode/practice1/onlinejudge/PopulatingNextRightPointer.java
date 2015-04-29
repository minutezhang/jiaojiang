package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: Apr 28, 2013 10:13:21 PM
 */
public class PopulatingNextRightPointer {
    /*
    Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    For example,
    Given the following perfect binary tree,

             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:

             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL
     */
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeLinkNode node = q.remove();
            if (node != null) {
                node.next = q.peek();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }

    public static void connect2(TreeLinkNode root) {

    }
}
