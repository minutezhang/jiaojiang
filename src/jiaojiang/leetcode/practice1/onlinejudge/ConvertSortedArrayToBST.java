package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: May 22, 2013 10:21:26 PM
 */
public class ConvertSortedArrayToBST {
    /*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }

    public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start == end) {
            return null;
        }

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }

//    0, 1, 2, 3, 4, 5, 6
//
//       3                                     3
//    /     \           ====>             /          \
// 0(left) 6(right)                 1                   5
//                                /   \              /      \
//                             0     2(3 - 1)   4(3 + 1)      6
    public static TreeNode sortedArrayToBSTIter(int[] num) {
        if (num.length == 0) {
            return null;
        }

        Queue<TreeNode> indices = new LinkedList<TreeNode>();
        int start = 0, end = num.length - 1, mid = (start + end + 1) >>> 1;

        TreeNode root = new TreeNode(mid);
        root.left = new TreeNode(start);
        root.right = new TreeNode(end);
        indices.add(root);

        while (!indices.isEmpty()) {
            TreeNode node = indices.remove();
            int nodeVal = node.val;
            node.val = num[nodeVal];

            if (node.left.val == nodeVal) {
                node.left = null;
            } else {
                node.left.left = new TreeNode(node.left.val);
                node.left.right = new TreeNode(nodeVal - 1);
                node.left.val = (node.left.left.val + node.left.right.val + 1) >>> 1;
                indices.add(node.left);
            }

            if (node.right.val == nodeVal) {
                node.right = null;
            } else {
                node.right.left = new TreeNode(nodeVal + 1);
                node.right.right = new TreeNode(node.right.val);
                node.right.val = (node.right.left.val + node.right.right.val + 1) >>> 1;
                indices.add(node.right);
            }
        }

        return root;
    }

    public static void test() {
        TreeNode.inOrder(sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println();
        TreeNode.inOrder(sortedArrayToBSTIter(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public static void main(String[] args) {
        test();
    }
}
