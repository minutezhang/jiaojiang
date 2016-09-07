package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 23, 2013 10:39:11 PM
 */
public class RecoverBST {
    /*
     Two elements of a binary search tree (BST) are swapped by mistake.

    Recover the tree without changing its structure.
    Note:
    A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
     */

    public static void recoverTree(TreeNode root){
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode lastNode = recoverTree(root, nodes, null);

        if (nodes.size() < 2) {
            nodes.add(lastNode);
        }

        if (nodes.size() == 2) {
            int tmp = nodes.get(0).val;
            nodes.get(0).val = nodes.get(1).val;
            nodes.get(1).val = tmp;
        }
    }

    public static TreeNode recoverTree(TreeNode root, List<TreeNode> nodes, TreeNode preNode) {
        if (root == null) {
            return preNode;
        }

        TreeNode pre = recoverTree(root.left, nodes, preNode);
        //first node
        if (pre == null) {
            return recoverTree(root.right, nodes, root);
        }

        if (nodes.isEmpty()) {
            if (pre.val > root.val) {
                nodes.add(pre);
            }
        } else if (nodes.size() < 2 && root.val > nodes.get(0).val) {
            nodes.add(pre);
            return root;
        }

        return recoverTree(root.right, nodes, root);
    }

    public static void recoverTree2(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        inorder(root, nodes);
        swap(nodes);
    }

    public static void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    public static void swap(List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        
        int firstIndex = 0;
        for (; firstIndex < nodes.size() - 1 && nodes.get(firstIndex).val < nodes.get(firstIndex + 1).val; firstIndex++);

        int secondIndex = firstIndex + 1;
        for (; secondIndex < nodes.size() && nodes.get(secondIndex).val < nodes.get(firstIndex).val; secondIndex++);

        int tmp = nodes.get(firstIndex).val;
        nodes.get(firstIndex).val = nodes.get(secondIndex - 1).val;
        nodes.get(secondIndex - 1).val = tmp;
    }

    public static void test() {
        TreeNode root = constructTree();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree2();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree3();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree(root);
        TreeNode.inOrder(root);

        System.out.println("\n");

        root = constructTree();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree2(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree2();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree2(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree3();
        TreeNode.inOrder(root);
        System.out.println();
        recoverTree2(root);
        TreeNode.inOrder(root);
    }

    public static TreeNode constructTree() {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(2);

        return root;
    }

    public static TreeNode constructTree2() {
        TreeNode root = new TreeNode(2);

        root.right = new TreeNode(1);

        return root;
    }

    public static TreeNode constructTree3() {
        TreeNode root = new TreeNode(64);

        root.left = new TreeNode(41);

        root.left.left = new TreeNode(-85);

        root.left.left.left = new TreeNode(-73);
        root.left.left.right = new TreeNode(-49);

        root.left.left.left.left = new TreeNode(-98);

        root.left.left.left.left.left = new TreeNode(-124);

        return root;
    }

    public static void main(String[] args) {
        test();
    }
}
