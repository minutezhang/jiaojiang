package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @since: Apr 23, 2013 9:05:52 PM
 */
public class PathSumII {
    /*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    For example:
    Given the below binary tree and sum = 22,

                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1

    return

    [
       [5,4,11,2],
       [5,8,4,5]
    ]
     */
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        pathSum(root, new ArrayList<Integer>(), sum, 0, ret);
        return ret;
    }

    public static void pathSum(TreeNode root, List<Integer> list, int sum, int currentSum, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                ret.add(tmp);
            }
            list.remove(list.size() - 1);
            return;
        }

        pathSum(root.left, list, sum, currentSum + root.val, ret);
        pathSum(root.right, list, sum, currentSum + root.val, ret);
        list.remove(list.size() - 1);
    }
}
