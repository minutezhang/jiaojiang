package jiaojiang.leetcode.facebook.onlinejudge;

import utils.Interval;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class MeetingRoomsII {
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    find the minimum number of conference rooms required.
    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return 2.
     */
    public static int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> sortedEndTime = new PriorityQueue<Integer>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval1) {
                return interval.start - interval1.start;
            }
        });

        int minMeetingRooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            for(; !sortedEndTime.isEmpty() && intervals[i].start > sortedEndTime.peek(); sortedEndTime.poll());
            sortedEndTime.add(intervals[i].end);
            minMeetingRooms = Math.max(minMeetingRooms, sortedEndTime.size());
        }

        return minMeetingRooms;
    }
}
