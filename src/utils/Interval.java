package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 1/28/15 7:41 PM
 */
public class Interval {
    public int start;
    public int end;
    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object anotherInterval) {
        return this.getClass() == anotherInterval.getClass()
                && this.start == ((Interval) anotherInterval).start
                && this.end == ((Interval) anotherInterval).end;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }

    //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18]
    public static List<Interval> getSampleIntervals() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 3));
        ret.add(new Interval(2, 6));
        ret.add(new Interval(5, 9));
        ret.add(new Interval(8, 10));
        ret.add(new Interval(15, 18));

        return ret;
    }

    //[1, 4], [4, 5]
    public static List<Interval> getSampleIntervals2() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(4, 5));

        return ret;
    }

    //[1, 4], [2, 3]
    public static List<Interval> getSampleIntervals3() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(2, 3));

        return ret;
    }

    //[1, 4], [0, 4]
    public static List<Interval> getSampleIntervals4() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(0, 4));

        return ret;
    }
}
