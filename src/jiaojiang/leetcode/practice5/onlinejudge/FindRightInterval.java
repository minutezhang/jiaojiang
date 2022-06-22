package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.Arrays;

public class FindRightInterval {
    /**
     * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
     * <p>
     * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
     * Note that i may equal j.
     * <p>
     * Return an array of right interval indices for each interval i. If no right interval exists for interval i,
     * then put -1 at index i.
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,2]]
     * Output: [-1]
     * Explanation: There is only one interval in the collection, so it outputs -1.
     * <p>
     * Example 2:
     * <p>
     * Input: intervals = [[3,4],[2,3],[1,2]]
     * Output: [-1,0,1]
     * Explanation: There is no right interval for [3,4].
     * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
     * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
     * <p>
     * Example 3:
     * <p>
     * Input: intervals = [[1,4],[2,3],[3,4]]
     * Output: [-1,2,-1]
     * Explanation: There is no right interval for [1,4] and [3,4].
     * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 2 * 10^4
     * intervals[i].length == 2
     * -10^6 <= starti <= endi <= 10^6
     * The start point of each interval is unique.
     */
    public static int[] findRightInterval2(int[][] intervals) {
        Integer[] indices = new Integer[intervals.length];
        int[] ret = new int[indices.length];
        for (int i = 0; i < indices.length; ++i) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> intervals[i1][0] - intervals[i2][0]);

        for (int i = 0; i < indices.length; ++i) {
            ret[indices[i]] = -1;
            if (intervals[indices[i]][1] == intervals[indices[i]][0]) {
                ret[indices[i]] = indices[i];
                continue;
            }
            for (int j = i + 1; j < indices.length; ++j) {
                if (intervals[indices[j]][0] >= intervals[indices[i]][1]) {
                    ret[indices[i]] = indices[j];
                    break;
                }
            }
        }
        return ret;
    }

    public static int[] findRightInterval(int[][] intervals) {
        Integer[] indices = new Integer[intervals.length];
        int[] ret = new int[indices.length];
        for (int i = 0; i < indices.length; ++i) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> intervals[i1][0] - intervals[i2][0]);

        for (int i = 0; i < indices.length; ++i) {
            if (intervals[indices[i]][1] == intervals[indices[i]][0]) {
                ret[indices[i]] = indices[i];
            } else {
                ret[indices[i]] = binarySearch(indices, intervals, i);
            }
        }
        return ret;
    }

    private static int binarySearch(Integer[] indices, int[][] intervals, int index) {
        int start = index + 1, end = indices.length - 1, target = intervals[indices[index]][1];
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (intervals[indices[mid]][0] >= target) {
                if (intervals[indices[mid - 1]][0] < target) {
                    return indices[mid];
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
