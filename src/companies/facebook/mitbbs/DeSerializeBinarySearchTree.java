package companies.facebook.mitbbs;

import jiaojiang.leetcode.practice2.onlinejudge.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Feb 3, 2014 12:16:02 AM
 */
public class DeSerializeBinarySearchTree {
    /*
    Serialize and Deserialize binary search tree
     */
   public static List<Integer> serialize(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorder(root, ret);
        return ret;
    }

    private static void preorder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        ret.add(root.val);
        preorder(root.left, ret);
        preorder(root.right, ret);
    }

    public static TreeNode deserialize(List<Integer> tree) {

        return construct(tree, 0, tree.size());
    }

    private static TreeNode construct(List<Integer> preorder, int start, int end) {
        if (start == end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(start));

        List<Integer> left = new ArrayList<Integer>();

        int index;
        for (index = start + 1; index < preorder.size() && preorder.get(index) < preorder.get(start); left.add(preorder.get(index)), index++);

        root.left = construct(left, 0, left.size());
        root.right = construct(preorder,  index, preorder.size());

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
    private static void test() {
        TreeNode root = TreeNode.getSampleBinarySearchTree();
        TreeNode.inOrder(root);
        System.out.println("\n>>>Below is the deserialized Binary Search Tree:");
        TreeNode.inOrder(deserialize(serialize(root)));
    }

    public static void main(String[] args) {
        test();
    }
}
