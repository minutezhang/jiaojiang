package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/12/15 3:48 PM
 */
public class MergeIntervals {
    /*
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
     */
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();

        if (intervals.size() == 0) {
            return ret;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval2) {
                return interval.start - interval2.start;
            }
        });

        Interval interval = intervals.get(0);
        ret.add(interval);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= interval.end) {
                interval.end = Math.max(intervals.get(i).end, interval.end);
            } else {
                interval = intervals.get(i);
                ret.add(interval);
            }
        }

        return ret;
    }
}
