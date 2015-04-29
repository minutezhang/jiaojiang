package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @since: May 17, 2013 11:23:48 PM
 */
public class PermutationSequence {
    /*
    The set [1,2,3,�,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3):
    �"123"
    �"132"
    �"213"
    �"231"
    �"312"
    �"321"


    Given n and k, return the kth permutation sequence.

    Note: Given n will be between 1 and 9 inclusive.
     */
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String ret = "";
        int[] p = new int[n];
        p[0] = 1;

        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * i;
        }

        while (!list.isEmpty()) {
            int s = list.size(), i = 1;

            for (; i <= s && k > i * p[s - 1]; i++);
            k -= (i - 1) * p[s - 1];
            ret += list.get(i - 1);
            list.remove(i - 1);
        }
        return ret;
    }

    public static void test() {
        System.out.println(getPermutation(3, 3));//213
        System.out.println(getPermutation(3, 5));//312
    }

    public static void main(String[] args) {
        test();
    }
}
