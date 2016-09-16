package jiaojiang.leetcode.uber.onlinejudge;

import utils.TreeNode;

/**
 * @author zhang
 *
 * Created on Sep 12, 2016
 */
public class HouseRobberIII {
    /*
    The thief has found himself a new place for his thievery again. There is only one entrance to this area, called
    the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized
    that "all houses in this place forms a binary tree". It will automatically contact the police if two
    directly-linked houses were broken into on the same night.

    Determine the maximum amount of money the thief can rob tonight without alerting the police.

    Example 1:

         3
        / \
       2   3
        \   \
         3   1

    Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    Example 2:

         3
        / \
       4   5
      / \   \
     1   3   1

    Maximum amount of money the thief can rob = 4 + 5 = 9.
     */
    public static int rob(TreeNode root) {
        return rob(root, true);        
    }

    private static int rob(TreeNode node, boolean canVisit) {
        if (node == null) {
            return 0;
        }

        if (canVisit) {
            return Math.max(node.val + rob(node.left, false) + rob(node.right, false),
                    rob(node.left, true) + rob(node.right,  true));
        }

        return rob(node.left, true) + rob(node.right, true);
    }
}
