package jiaojiang.leetcode.practice2.onlinejudge;

/**
 * @author: zhang
 * @since: Feb 2, 2014 9:59:40 PM
 */
public class Point {
    int x;
    int y;
    Point() {
        x = 0;
        y = 0;
    }
    
    Point(int a, int b) {
        x = a;
        y = b;
    }

    public static Point[] getPoints() {
        return new Point[]{
                new Point(0, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        };
    }
}
