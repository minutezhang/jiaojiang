package jiaojiang.leetcode.practice1.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang@akamai.com
 */
public class SumRootToLeafNumbers {
    /*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    For example,

        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
     */

    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, new ArrayList<Integer>(), 0);
    }

    public static int sumNumbers(TreeNode node, List<Integer> values, int currentSum) {
        if (node == null) {
            return currentSum;
        }

        if (node.left == null && node.right == null) {
            int sum = 0;
            for (int n : values) {
                sum = sum * 10 + n;
            }
            return sum * 10 + node.val + currentSum;
        }

        values.add(node.val);
        int sum = sumNumbers(node.left, values, currentSum);
        sum = sumNumbers(node.right, values, sum);
        values.remove(values.size() - 1);

        return sum;
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }

    public static void main(String[] args) {
        test();
    }
}
