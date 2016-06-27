package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang
 *
 * Created on May 26, 2016
 */
public class IntersectionOfTwoArrays {
    /*
    Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

    Note:

        Each element in the result must be unique.
        The result can be in any order.
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }

        List<Integer> inter = new ArrayList<Integer>();

        for (int i : nums2) {
            if (set.contains(i)) {
                inter.add(i);
                set.remove(i);
            }
        }

        int[] ret = new int[inter.size()];
        for (int i = 0; i < inter.size(); i++) {
            ret[i] = inter.get(i);
        }
        return ret;
    }
}
