package companies.google.mitbbs;

import utils.Test;
import utils.TreeNode;

/**
 * @author: mizhang
 * @since: Oct 31, 2013 4:50:29 PM
 */
public class ClosestNumberInBST {
    /*
    Given a number and a Binary Search Tree, find the closest number in BST, by closest, means the absolute value of the difference is
    minimal
     */

    public static int min(TreeNode bst, int number) {
        return min(bst, number, 0, Integer.MAX_VALUE);
    }

    private static int min(TreeNode node, int number, int currentMin, int currentDiff) {
        if (node == null) {
            return currentMin;
        }

        int diff;
        if ((diff = node.val - number) == 0) {
            return node.val;
        }

        if (diff < 0) {
            if (currentDiff > -diff) {
                currentMin = node.val;
                currentDiff = -diff;
            }
            return min(node.right, number, currentMin, currentDiff);
        }

        if (currentDiff > diff) {
            currentMin = node.val;
            currentDiff = diff;
        }

        return min(node.left, number, currentMin, currentDiff);
    }

    public static int min2(TreeNode bst, int number) {
        int min = 0;
        long minDiff = (long)Integer.MAX_VALUE - (long)Integer.MIN_VALUE;
//        long minDiff = Integer.MAX_VALUE - Integer.MIN_VALUE;

        TreeNode node = bst;
        while (node != null) {
            long diff = node.val - number;
            if (diff == 0) {
                return node.val;
            }

            if (diff < 0) {
                if (minDiff > -diff) {
                    minDiff = -diff;
                    min = node.val;
                }
                node = node.right;
            } else {
                if (minDiff > diff) {
                    minDiff = diff;
                    min = node.val;
                }
                node = node.left;
            }
        }

        return min;
    }

    public static void test() {
            /*
             8
          /      \
         4       19
        / \     /  \
       3   6   11  20
            \   \
            7   14
     */
        TreeNode root = TreeNode.getSampleBinarySearchTree();

        Test.assertEquals(11, min(root, 10));
        Test.assertEquals(20, min(root, 21));
        Test.assertEquals(19, min(root, 19));
        Test.assertEquals(3, min(root, 1));
        Test.assertEquals(14, min(root, 15));


        Test.assertEquals(11, min2(root, 10));
        Test.assertEquals(20, min2(root, 21));
        Test.assertEquals(19, min2(root, 19));
        Test.assertEquals(3, min2(root, 1));
        Test.assertEquals(14, min2(root, 15));
    }

    public static void main(String[] args) {
        test();
    }
}
