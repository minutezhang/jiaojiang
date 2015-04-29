package companies.facebook.careercup;

import utils.Utils;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @since: Feb 5, 2014 4:48:35 PM
 */
public class RemoveDuplicates {
    /*
    Given an array, remove the duplicates and return a unique array keeping the first occurrence of the duplicates and the order.

    [@2, @1, @3, @1, @2] --> [@2, @1, @3]
     */
    public static int[] removeDuplicates(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            }
        }

        int[] ret = new int[map.size()];
        for (int i : map.keySet()) {
            ret[map.get(i)] = i;
        }
        return ret;
    }

    private static void test() {
        Utils.printArrayln(removeDuplicates(new int[]{2, 1, 3, 1, 2}));
    }

    public static void main(String[] args) {
        test();
    }
}
