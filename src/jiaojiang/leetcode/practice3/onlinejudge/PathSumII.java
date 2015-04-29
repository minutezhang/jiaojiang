package jiaojiang.leetcode.practice3.onlinejudge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/2/15 10:04 PM
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
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {


        // COMMENTED code is wrong
//        if (root == null) {
//            List<List<Integer>> ret = new ArrayList<List<Integer>>();
//            if (sum == 0) {
//                List<Integer> path = new ArrayList<Integer>();
//                ret.add(path);
//            }
//            return ret;
//        }
//
//        List<List<Integer>> ret = pathSum(root.left, sum - root.val);
//        ret.addAll(pathSum(root.right, sum - root.val));
//
//        for (List<Integer> l : ret) {
//            l.add(0, root.val);
//        }

        if (root == null ) {
            return new ArrayList<List<Integer>>();
        }

        if (root.left == null && root.right == null && sum == root.val) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            ret.add(path);
            return ret;
        }

        List<List<Integer>> ret = pathSum(root.left, sum - root.val);
        ret.addAll(pathSum(root.right, sum - root.val));

        for (List<Integer> l : ret) {
            l.add(0, root.val);
        }

        return ret;
    }
}
