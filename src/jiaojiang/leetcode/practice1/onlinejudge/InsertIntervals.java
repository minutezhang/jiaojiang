package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: May 18, 2013 12:03:18 AM
 */
public class InsertIntervals {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();

        int index = 0;
        for (; index < intervals.size() && intervals.get(index).start <= newInterval.start; index++) {
            ret.add(intervals.get(index));
        }

        if (!ret.isEmpty()) {
            Interval interval = ret.remove(ret.size() - 1);
            if (interval.end >= newInterval.start) {
                newInterval.start = interval.start;
            } else {
                ret.add(interval);
            }
        }

        for (; index < intervals.size() && newInterval.end >= intervals.get(index).start; index++);

        if (index > 0 ) {
            newInterval.end = Math.max(intervals.get(index - 1).end, newInterval.end);
        }
        
        ret.add(newInterval);
        for (; index < intervals.size(); index++) {
            ret.add(intervals.get(index));
        }

        return ret;
    }

    public static void test() {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        for (Interval interval : insert(intervals, new Interval(2, 5))) {   //[1, 5], [6, 9]
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

        for (Interval interval : insert(new ArrayList<Interval>(), new Interval(2, 5))) {  //[2, 5]
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

        intervals.clear();
        intervals.add(new Interval(1, 5));

        for (Interval interval : insert(intervals, new Interval(0, 0))) {   //[0, 0], [1, 5]
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

        intervals.clear();
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));

        for (Interval interval : insert(intervals, new Interval(0, 10))) {   //[0, 10]
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }
    }

    public static void main(String[] args) {
        test();
    }
}
