package companies.facebook.mitbbs;

import utils.NTreeNode;
import utils.TreeNode;

import java.util.Stack;

/**
 * @author: mizhang
 * @since: Nov 27, 2013 1:50:49 PM
 */
public class TreePreorderTraversal {
    /*
    Given a regular tree, write the iterative preorder traversal algorithm
     */
    public static void preorder(NTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "\t");
        if (root.children == null) {
            return;
        }
        for (NTreeNode node : root.children) {
            preorder(node);
        }
    }

    public static void preorderIter(NTreeNode root) {
        Stack<NTreeNode> stack = new Stack<NTreeNode>();
        NTreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
            }
            System.out.print(node.value + "\t");
            if (node.children != null) {
                for (int i = node.children.size() - 1; i > 0; i--) {
                    stack.push(node.children.get(i));
                }
                node = node.children.get(0);
            } else {
                node = null;
            }
        }
    }

    public static void test() {
        NTreeNode root = NTreeNode.constructSampleTree();
        preorder(root);

        System.out.println();
        preorderIter(root);

        System.out.println();
        preorderBinaryTree(TreeNode.getSampleTree());
    }

    public static void preorderBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
            }
            System.out.print(node.val + "\t");
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }
    }

    public static void main(String[] args) {
        test();
    }
}
