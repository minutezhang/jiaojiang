package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Jun 21, 2016
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
        Map<Integer, Boolean> notVisited = new HashMap<Integer, Boolean>();
        for (int n : nums) {
            notVisited.put(n, true);
        }

        int start = 0, maxLength = 0;
        for (int n : nums) {
            int length, s;
            for (s = n, length = 0; notVisited.containsKey(s) && notVisited.get(s); length++, notVisited.put(s, false), s++){};
            for (s = n - 1; notVisited.containsKey(s) && notVisited.get(s); length++, notVisited.put(s, false), s--){};
            if (length > maxLength) {
                start = s;
                maxLength = length;
            }
        }

        return maxLength;
    }
}
