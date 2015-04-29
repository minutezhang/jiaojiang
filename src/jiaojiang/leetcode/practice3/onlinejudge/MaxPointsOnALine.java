package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 3:18:41 PM
 */
public class MaxPointsOnALine {
    /*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */
    public static int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }

        int maxCount = 2;
        Map<Double, Integer> slopeCounts = new HashMap<Double, Integer>();

        for (int i = 0; i < points.length - 1; i++) {
            slopeCounts.clear();
            int samePointCount = 0, maxRoundCount = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePointCount++;
                } else {
                    Double slope = points[j].x == points[i].x ? Double.NaN : points[i].y == points[j].y ? 0 : (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                    int slopeCount = 2;
                    if (slopeCounts.containsKey(slope)) {
                        slopeCount = slopeCounts.get(slope) + 1;
                    }
                    slopeCounts.put(slope, slopeCount);
                    
                    if (slopeCount > maxRoundCount) {
                        maxRoundCount = slopeCount;
                    }
                }
            }

            if (maxRoundCount + samePointCount > maxCount) {
                maxCount = maxRoundCount + samePointCount;
            }
        }

        return maxCount;
    }

    public static void test() {
        Test.assertEquals(1, maxPoints(new Point[]{new Point(0, 0)}));
        Test.assertEquals(3, maxPoints(new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0)}));
        Test.assertEquals(2, maxPoints(new Point[]{new Point(0, 0), new Point(1, 1), new Point(1, -1)}));
        Test.assertEquals(3, maxPoints(new Point[]{new Point(0, 0), new Point(1, 1), new Point(-1, -1)}));
        Test.assertEquals(4, maxPoints(new Point[]{new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(-1, -1)}));
    }

    public static void main(String[] args) {
        test();
    }
}
