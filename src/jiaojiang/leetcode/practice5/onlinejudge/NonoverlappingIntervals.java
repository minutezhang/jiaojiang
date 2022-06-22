package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.Arrays;

public class NonoverlappingIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals
     * you need to remove to make the rest of the intervals non-overlapping.
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     * <p>
     * Example 2:
     * <p>
     * Input: intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
     * <p>
     * Example 3:
     * <p>
     * Input: intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 10^5
     * intervals[i].length == 2
     * -5 * 10^4 <= starti < endi <= 5 * 10^4
     */
    public static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] intv : intervals) {
            System.out.println(intv[0] + "," + intv[1]);
        }
        int count = 0, prevIndex = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= intervals[prevIndex][0] && intervals[i][0] < intervals[prevIndex][1]) {
                ++count;
            } else {
                prevIndex = i;
            }
        }
        return count;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int count = 0, current = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if(interval[0] >= current) {
                ++count;
                current = interval[1];
            }
        }
        return intervals.length - count;
    }
}
