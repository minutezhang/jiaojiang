package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on May 26, 2016
 */
public class IntersectionOfTwoArraysII {
    /*
    Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

    Note:

        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.

    Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to num2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }

        List<Integer> inter = new ArrayList<Integer>();

        for (int i : nums2) {
            if (counts.containsKey(i) && counts.get(i) > 0) {
                inter.add(i);
                counts.put(i, counts.get(i) - 1);
            }
        }

        int[] ret = new int[inter.size()];

        for (int i = 0; i < inter.size(); i++) {
            ret[i] = inter.get(i);
        }

        return ret;
    }
}
