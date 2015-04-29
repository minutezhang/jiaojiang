package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/28/15 7:40 PM
 */
public class InsertInterval {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        int i = 0;
        for (; i < intervals.size() && newInterval.start > intervals.get(i).end; ret.add(intervals.get(i)), i++);

        ret.add(newInterval);

        if (i == intervals.size()) {
            return ret;
        }

        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);

        for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; newInterval.end = Math.max(newInterval.end, intervals.get(i).end), i++);

        for (; i < intervals.size(); ret.add(intervals.get(i)), i++);

        return ret;
    }
}
