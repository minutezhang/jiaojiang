package companies.facebook.glassdoor;

import jiaojiang.leetcode.practice2.onlinejudge.Interval;

import java.util.List;
import java.util.Arrays;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 7, 2014 9:27:27 PM
 */
public class MaxNumOverlappingIntervals {
    /*

    Given n intervals [si, fi], find the maximum number of overlapping intervals

    Or equivalently,

    Given a vector of Nodes, each of which contain the start and end time of a meeting, find the maximum number of
    rooms one would have to book for the day.  
     */
    public static int maxOverlap(List<Interval> intervals) {
        int[] start = new int[intervals.size()], end = new int[intervals.size()];
        int count = 0, maxCount = 0;
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0, j = 0; i < start.length && j < end.length; ) {
            if (start[i] == end[j]) {
                i++;
                j++;
            } else if (start[i] < end[j]) {
                i++;
                maxCount = Math.max(++count, maxCount);
            } else {
                j++;
                count--;
            }
        }
        return maxCount;
    }

    private static void test() {
        //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18]
        Utils.printTestln(maxOverlap(Interval.getSampleIntervals()), 2);

        //[1, 4], [4, 5]
        Utils.printTestln(maxOverlap(Interval.getSampleIntervals2()), 1);

        //[1, 4], [2, 3]        
        Utils.printTestln(maxOverlap(Interval.getSampleIntervals3()), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
