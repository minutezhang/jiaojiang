package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class MajorityElementII {
    /*
    Given an integer array of size n, find all elements that appear more than ? n/3 ? times. The algorithm should run
    in linear time and in O(1) space.

    Hint:

        How many majority elements could it possibly have?
        Do you have a better hint? Suggest it!
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        Map<Integer, Integer> twoCounts = new HashMap<Integer, Integer>();
        Set<Integer> keys = new HashSet<Integer>();

        for (int n : nums) {
            if (twoCounts.containsKey(n)) {
                twoCounts.put(n, twoCounts.get(n) + 1);
            } else if (twoCounts.size() < 2) {
                twoCounts.put(n, 1);
            } else {
                for (int k : twoCounts.keySet()) {
                    int v = twoCounts.get(k);
                    if (v == 1) {
                        keys.add(k);
                    } else {
                        twoCounts.put(k, v - 1);
                    }
                }
                for (int k : keys) {
                    twoCounts.remove(k);
                }
                keys.clear();
            }
        }

        for (int k : twoCounts.keySet()) {
            twoCounts.put(k, 0);
        }
        
        for (int n : nums) {
            if (twoCounts.containsKey(n)) {
                twoCounts.put(n, twoCounts.get(n) + 1);
            }
        }

        for (int k : twoCounts.keySet()) {
            if (twoCounts.get(k) > nums.length/3) {
                ret.add(k);
            }
        }
        
        return ret;
    }
}
