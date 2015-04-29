package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author: zhang
 * @since: Nov 23, 2013 10:18:47 PM
 */
public class MaxPointsOnALine {
    /*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line
     */
    //NOTE: 1. please pay attention when you calculate the slope, it is int/int and please case to double
    //      2. in hash, 0.0 == -0.0 but new Double(0.0).equals(new Double(-0.0)) is false
    public static int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }

        int max = 1;
        Map<Double, Integer> slopeCount = new HashMap<Double, Integer>();

        for (int i = 0; i < points.length; i++) {
            slopeCount.clear();
            int base = 1;
            for (int j = i + 1; j < points.length; j++) {
                //in case duplicate points
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    base++;
                } else {
                    double slope = points[j].x == points[i].x ? Double.NaN : (points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    // in case slope == -0.0, the hash map has two entries 0.0 and -0.0. Please notice 0.0 == -0.0 but,
                    // new Double(0.0).equals(new Double(-0.0)) is false
                    if (slope == 0.0) {
                        slope = 0.0;
                    }
                    slopeCount.put(slope, !slopeCount.containsKey(slope) ? 1 : slopeCount.get(slope) + 1);
                }
            }
            max = Math.max(max, base); // in case all are same points
            for (Double d : slopeCount.keySet()) {
                max = Math.max(slopeCount.get(d) + base, max);
            }
        }

        return max;
    }

    private static void test() {
        Utils.printTestln(maxPoints(Point.getPoints()), 3);
        Utils.printTestln(maxPoints(new Point[]{new Point(), new Point(1, 1), new Point()}), 3);
        Utils.printTestln(maxPoints(new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)}), 3);
        Utils.printTestln(maxPoints(new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)}), 3);
        Utils.printTestln(maxPoints(new Point[]{new Point(84,250), new Point(0, 0), new Point(1, 0), new Point(0, -70),
                new Point(0, -70), new Point(1, -1), new Point(21, 10), new Point(42, 90), new Point(-42, -230)}), 6);
    }

    public static void main(String[] args) {
        test();
    }
}
