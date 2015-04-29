package companies.facebook.careercup;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Feb 5, 2014 2:42:25 PM
 */
public class CombinationSum {
    /*
    Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists.
    (Exclude the N+0=N)

    For example, if N=4 return {{1,1,1,1},{1,1,2},{2,2},{1,3}}
     */
    public static List<? extends List<Integer>> combinationSum(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        combinationSum(n, ret, new ArrayList<Integer>());
        
        return ret;
    }

    private static void combinationSum(int n, List<List<Integer>> ret, List<Integer> intList) {
        if (n == 0) {
            if (intList.size() > 1) {
                ret.add(new ArrayList<Integer>(intList));
            }
            return;
        }

        int start = intList.isEmpty() ? 1 : intList.get(intList.size() - 1);
        for (int i = start; i <= n; i++) {
            intList.add(i);
            combinationSum(n - i, ret, intList);
            intList.remove(intList.size() - 1);
        }
    }

    private static void test() {
        Utils.printListListln(combinationSum(4));
        Utils.printListListln(combinationSum(8));
    }

    public static void main(String[] args) {
        test();
    }
}
