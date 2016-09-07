package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.Set;
import java.util.HashSet;

/**
 * @author zhang
 *
 * Created on Aug 31, 2016
 */
public class LongestConsecutiveSequence {
    /*
     Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();

        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;
        for (int num: nums) {
            if (numSet.contains(num)) {
                int upper, lower;
                for (upper = num + 1; numSet.contains(upper); numSet.remove(upper++));
                for (lower = num - 1; numSet.contains(lower); numSet.remove(lower--));
                maxLength = Math.max(maxLength, upper - lower - 1);
            }
        }

        return maxLength;
    }
}
