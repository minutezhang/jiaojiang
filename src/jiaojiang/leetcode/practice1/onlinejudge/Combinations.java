package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: May 5, 2013 10:55:51 PM
 */
public class Combinations {
    /*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
     */

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(i);
                ret.add(set);
            }
            return ret;
        }

        for (int i = n - 1; i >= k - 1 ; i--) {
            ArrayList<ArrayList<Integer>> combinations = combine(i, k - 1);
            for (ArrayList<Integer> set : combinations) {
                set.add(i + 1);
                ret.add(set);
            }
        }

        return ret;
    }

//    public static ArrayList<ArrayList<Integer>> combine2(int n, int k) {
//
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
//
//        for (int i = 0; i < k; i++) {
//
//
//
//
//        }
//
//    }

    public static void test() {
        for (ArrayList<Integer> set : combine(4, 2)) {
            for (int i : set) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("-------------");
        
//        for (ArrayList<Integer> set : combine2(4, 2)) {
//            for (int i : set) {
//                System.out.print(i + " ");
//            }
//            System.out.printTestln();
//        }
    }

    public static void main(String[] args) {
        test();
    }
}
