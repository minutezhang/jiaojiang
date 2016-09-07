package jiaojiang.leetcode.facebook.onlinejudge;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class MeetingRooms {
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    determine if a person could attend all meetings.
    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return false.
     */
    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval1) {
                return interval.start - interval1.start;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}
