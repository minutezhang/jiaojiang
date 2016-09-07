package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Interval;

import java.util.*;

/**
 * @author: zhang
 * @since: Apr 15, 2013 12:22:00 AM
 */
public class MergeIntervals {
    /*
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
     */
    public static List<Interval> merge(ArrayList<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval, Interval interval1) {
                if (interval.start < interval1.start) {
                    return -1;
                }

                if (interval.start == interval1.start) {
                    return 0;
                }

                return 1;
            }
        });

        int i = 0, n = intervals.size();
        while (i < n) {
            Interval start = intervals.get(i);
            int end = start.end, j = i + 1;
            for (; j < n && intervals.get(j).start <= end; j++) {
                if (end < intervals.get(j).end) {
                    end = intervals.get(j).end;
                }
            }
            mergedIntervals.add(new Interval(start.start, end));
            i = j;
        }

        return mergedIntervals;
    }

//    test cases:
//    []	[]
//
//    [[1,3]]	[[1,3]]
//
//    [[1,4],[1,4]]	[[1,4]]
//
//    [[1,4],[1,5]]	[[1,5]]
//
//    [[1,4],[2,5]]	[[1,5]]
//
//    [[1,4],[4,5]]	[[1,5]]
//
//    [[1,4],[5,6]]	[[1,4],[5,6]]
//
//    [[1,4],[0,4]]	[[0,4]]
//
//    [[1,4],[0,1]]	[[0,4]]
//
//    [[1,4],[0,2]]	[[0,4]]
//
//    [[1,4],[2,3]]	[[1,4]]
//
//    [[1,4],[0,5]]	[[0,5]]
//
//    [[1,4],[0,0]]	[[0,0],[1,4]]
//
//    [[1,4],[0,2],[3,5]]	[[0,5]]
}
