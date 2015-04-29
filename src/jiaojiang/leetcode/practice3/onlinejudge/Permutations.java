package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/2/15 10:48 PM
 */
public class Permutations {
    /*
    Given a collection of numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = permute(num, num.length);
        return ret;
    }

    public static List<List<Integer>> permute(int[] num, int length) {
        if (length == 0) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            ret.add(new ArrayList<Integer>());
            return ret;
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < length; i++) {
            swap(num, i, length - 1);
            List<List<Integer>> permutation = permute(num, length - 1);
            for (List<Integer> l : permutation) {
                l.add(num[length - 1]);
            }
            ret.addAll(permutation);
            swap(num, i, length - 1);
        }

        return ret;
    }

    private static void swap(int[] num, int i, int j) {
        if (i != j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }

    /*
    {} -> {1} -> {2,1}; {1,2} -> {3,2,1},{2,3,1},{2,1,3}; {3,1,2},{1,3,2},{1,2,3}

    that is {1,2} == adding x => {x, 1, 2}, {1, x, 2}, {1, 2, x}
     */
    public static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            for (int j = 0, s = ret.size(); j < s; j++) {
                List<Integer> l = ret.get(j);
                for (int k = 0; k < l.size(); k++) {
                    List<Integer> ll = new ArrayList<Integer>(l);
                    ll.add(k, num[i]);
                    ret.add(ll);
                }
                l.add(num[i]);
            }
        }

        return ret;
    }
}