package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 4, 2013 4:26:01 PM
 */
public class SubsetII {
    /*
    Given a collection of integers that might contain duplicates, S, return all possible subsets.

    Note:
    
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        ret.add(subset);

        if (num.length == 0) {
            return ret;
        }

        Arrays.sort(num);
        int pre = num[0] == Integer.MAX_VALUE ? num[0] - 1 : num[0] + 1, lastIndex = ret.size(), index;
        for (int i : num) {
            if (pre != i) {
                index = 0;
            } else {
                index = lastIndex;
            }

            lastIndex = ret.size();
            for (; index < lastIndex; index++) {
                subset = new ArrayList<Integer>(ret.get(index));
                subset.add(i);
                ret.add(subset);
            }
            pre = i;
        }

        return ret;
    }

    public static void test(int[] num) {
        for (ArrayList<Integer> subset : subsetsWithDup(num)) {
            for (int i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void test() {
        test(new int[]{1, 2});
        test(new int[]{1, 2, 2});
        test(new int[]{1, 2, 2, 2});
    }

    public static void main(String[] args) {
        test();
    }
}
