package companies.misc.mitbbs;

import utils.TreeNode;
import utils.TreeNodeWithParent;


/**
 * @author: mizhang
 * @since: Sep 9, 2013 2:14:46 PM
 */
public class NextBST {

    //return the next node in BST given the current node, also the parent of the current node is available
    public static int nextNode(TreeNodeWithParent node) {

        if (node.right != null) {
            TreeNode tmpNode = node.right;
            while (tmpNode.left != null) {
                tmpNode = tmpNode.left;
            }
            return tmpNode.val;
        }

        TreeNodeWithParent n = node, p = node.parent;

        while (p != null && p.right == n) {
            n = p;
            p = n.parent;
        }

        return p == null ? Integer.MIN_VALUE : p.val;

    }

    public static void test() {
//        TreeNodeWithParent root = TreeNode.getSampleBinarySearchTree3();
//
//        Utils.printTestln(nextNode(root.left), 7);
//        Utils.printTestln(nextNode(root.left.left), 5);
//        Utils.printTestln(nextNode(root.right), 17);
//        Utils.printTestln(nextNode(root.right.left), 16);
//        Utils.printTestln(nextNode(root.right.right), 19);
    }

    public static void main(String[] args) {
        test();
    }
}
