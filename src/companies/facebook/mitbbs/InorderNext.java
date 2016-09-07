package companies.facebook.mitbbs;

import utils.Utils;
import utils.TreeNode;

import java.util.Stack;

/**
 * @author: zhang
 * @since: Feb 3, 2014 10:30:27 PM
 */
public class InorderNext {
    public static TreeNode getInorderNext(TreeNode root, TreeNode node) {
        return getInorderNext(root, node, new TreeNode[1]);
    }

    public static TreeNode getInorderNext(TreeNode root, TreeNode node, TreeNode[] preNode) {
        if (root == null) {
            return null;
        }

        TreeNode n = getInorderNext(root.left, node, preNode);
        if (n != null) {
            return n;
        }
        if (preNode[0] == node) {
            return root;
        }
        preNode[0] = root;

        return getInorderNext(root.right, node, preNode);
    }

    public static TreeNode getInorderNext2(TreeNode root, TreeNode target) {
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode node = root, preNode = null;
        while (!s.isEmpty() || node != null) {
            if (node == null) {
                node = s.pop();
                if (preNode == target) {
                    return node;
                }
                preNode = node;
                node = node.right;
            } else {
                s.add(node);
                node = node.left;
            }
        }

        return root;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        TreeNode root = TreeNode.getSampleTree();
        Utils.printTestln(getInorderNext(root, root.right).val, 6);
        Utils.printTestln(getInorderNext(root, root.left).val, 4);
        Utils.printTestln(getInorderNext(root, root.left.left).val, 2);
        Utils.printTestln(getInorderNext(root, root.left.right).val, 1);

        System.out.println("\n>>>Below is the iterative version:\n");

        Utils.printTestln(getInorderNext2(root, root.right).val, 6);
        Utils.printTestln(getInorderNext2(root, root.left).val, 4);
        Utils.printTestln(getInorderNext2(root, root.left.left).val, 2);
        Utils.printTestln(getInorderNext2(root, root.left.right).val, 1);
    }

    public static void main(String[] args) {
        test();
    }
}
