package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Apr 16, 2013 4:07:11 PM
 */
public class Permutations {
    /**
     * Given a collection of numbers, return all possible permutations.

        For example,
        [1,2,3] have the following permutations:
        [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i : num) {
            numList.add(i);
        }
        ret.add(numList);

        for (int level = 0; level < num.length - 1; level++) {
            for (int j = 0, n = ret.size(); j < n; j++) {
                ArrayList<Integer> list = ret.get(j);
                for (int i = level + 1; i < num.length; i++) {
                    numList = new ArrayList<Integer>(list);
                    int tmp = numList.get(i);
                    numList.set(i, numList.get(level));
                    numList.set(level, tmp);
                    ret.add(numList);
                }
            }
        }

        return ret;
    }

    public static void printPermutations(int[] num) {
        printPermutationsHelp(num, 0);
    }

    public static void printPermutationsHelp(int[] num, int level) {
        if (level == num.length) {
            for (int i : num) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        for (int i = level; i < num.length; i++) {
            swap(num, i, level);
            printPermutationsHelp(num, level + 1);
            swap(num, i, level);
        }
    }

    public static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void test() {
//        printPermutations(new int[] {1, 2, 3});
        ArrayList<ArrayList<Integer>> p = permute(new int[] {1, 2, 3});
        for (ArrayList<Integer> l : p) {
            for (int i : l) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
