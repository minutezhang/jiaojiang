package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: mizhang@akamai.com
 */
public class PermutationII {
    /*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
        [1,1,2] have the following unique permutations:
        [1,1,2], [1,2,1], and [2,1,1].
    */
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        for (int i : num) {
            permutation.add(i);
        }

        Collections.sort(permutation);
        do {
            ret.add(permutation);
        } while ( (permutation = getNextPermutation(permutation)) != null);

        return ret;
    }

    public static ArrayList<Integer> getNextPermutation (ArrayList<Integer> num) {
        int i = num.size() - 2, j;
        for (; i >= 0 && num.get(i) >= num.get(i + 1); i--);
        if (i == -1) {
            return null;
        }

        ArrayList<Integer> ret = new ArrayList<Integer>(num);
        for (j = ret.size() - 1; j >= i + 1 && ret.get(j) <= ret.get(i) ; j--);
        swap(ret, i, j);
        reserve(ret,  i + 1, ret.size() - 1);

        return ret;
    }

    public static void swap(ArrayList<Integer> num, int i, int j) {
        int tmp = num.get(i);
        num.set(i, num.get(j));
        num.set(j, tmp);
    }

    public static void reserve(ArrayList<Integer> num, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(num, i++, j--);
        }
    }

    public static void testHelp(int[] num) {
        for (ArrayList<Integer> l : permuteUnique(num)) {
            for (int i : l) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void test() {
        testHelp(new int[]{1, 1, 2});
        System.out.println("\n\n");
        testHelp(new int[]{1, 1, 2, 2});

    }

    public static void main(String[] args) {
        test();
    }

}
