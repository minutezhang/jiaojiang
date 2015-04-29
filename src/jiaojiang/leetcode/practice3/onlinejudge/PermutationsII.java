package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/10/15 12:40 PM
 */
public class PermutationsII {
    /*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
    [1,1,2], [1,2,1], and [2,1,1].
     */
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            for (int j = 0, s = ret.size(); j < s; j++) {
                List<Integer> l = ret.get(j);
                int endIndex;

                for (endIndex = 0; endIndex < l.size() && l.get(endIndex) != num[i]; endIndex++);

                for (int k = endIndex; k > 0; k--) {
                    List<Integer> ll = new ArrayList<Integer>(l);
                    ll.add(k, num[i]);
                    ret.add(ll);
                }
                l.add(0, num[i]);
            }

            System.out.println(i + " index");
            for (int j = 0; j < ret.size(); j++) {
                List<Integer> lll = ret.get(j);
                for (int k = 0; k < lll.size(); k++) {
                    System.out.print(lll.get(k) + "\t");
                }
                System.out.println("");
            }
        }

        return ret;
    }

    public static List<List<Integer>> permuteUnique2(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        List<Integer> list = new ArrayList<Integer>();
        for (int i : num) {
            list.add(i);
        }
        ret.add(list);

        while ((list = nextGreat(list)) != null) {
            ret.add(list);
        }

        return ret;
    }

    private static List<Integer> nextGreat(List<Integer> l) {
        List<Integer> ret = null;
        int index;
        for (index = l.size() - 1; index > 0 && l.get(index) <= l.get(index - 1); index--);

        if (index > 0) {
            ret = new ArrayList<Integer>(l);
            int i;
            for (i = ret.size() - 1; i >= index && ret.get(i) <= ret.get(index - 1); i--);
            swap(ret, index - 1, i);

            for (i = 0; i < (ret.size() - index + 1) / 2; i++) {
                swap(ret, index + i, ret.size() - 1 - i);
            }
        }

        return ret;

    }

    private static void swap(List<Integer> l, int i, int j) {
        if (i != j) {
            int tmp = l.get(i);
            l.set(i, l.get(j));
            l.set(j, tmp);
        }
    }
}