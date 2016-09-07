package jiaojiang.leetcode.facebook.onlinejudge;

import utils.Interval;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
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
        int index;
        for (index = 0; index < intervals.size() && intervals.get(index).end < newInterval.start; index++) {
            ret.add(intervals.get(index));
        }

        for (; index < intervals.size() && newInterval.end >= intervals.get(index).start; index++) {
            newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end); 
        }

        ret.add(newInterval);

        for (; index < intervals.size(); index++) {
            ret.add(intervals.get(index));
        }

        return ret;
    }
}
