package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: Apr 21, 2013 11:19:47 PM
 */
public class Subsets {
    /*
     Given a set of distinct integers, S, return all possible subsets.

    Note:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.

    For example,
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());

        for (int i : S) {
            for(int j = 0, n = subsets.size(); j < n; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>(subsets.get(j));
                subset.add(i);
                subsets.add(subset);
            }
        }

        return subsets;
    }

    public static void test() {
        ArrayList<ArrayList<Integer>> subsets = subsets(new int[]{2, 3, 1});
        for (ArrayList<Integer> subset : subsets) {
            System.out.print("[ ");
            for (int i : subset) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        test();
    }
}
