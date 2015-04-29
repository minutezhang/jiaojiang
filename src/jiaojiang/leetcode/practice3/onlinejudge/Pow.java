package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Mar 7, 2015 9:26:56 PM
 */
public class Pow {
    /*
    Implement pow(x, n). 
     */
    public static double pow(double x, int n) {
        double result = 1;
        long ln = n < 0 ? -(long)n : n;
        while (ln >= 1) {
            if ((ln & 1) == 1) {
                result *= x;
                ln = ln - 1;
            } else {
                x *= x;
                ln >>= 1;
            }
        }

        return n >= 0 ? result : 1.0/result;
    }
}
