package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

/**
 * @author: mizhang
 * @time: 3/3/15 6:24 PM
 */
public class ConvertSortedArraytoBinarySearchTree {
    /*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }

    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start == end) {
            return null;
        }

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(num[mid]);

        root.left =  sortedArrayToBST(num, start, mid);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }
}
