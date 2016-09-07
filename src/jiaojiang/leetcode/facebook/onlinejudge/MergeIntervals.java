package jiaojiang.leetcode.facebook.onlinejudge;

import utils.Interval;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
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
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval1) {
                return interval.start - interval1.start;
            }
        });

        if (intervals.isEmpty())  {
            return ret;
        }

        Interval interval = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);
            if (nextInterval.start <= interval.end) {
                interval.end = Math.max(interval.end, nextInterval.end);
            } else {
                ret.add(interval);
                interval = nextInterval;
            }
        }

        ret.add(interval);

        return ret;
    }
}
