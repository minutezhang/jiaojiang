package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
 */
public class Pow {
    /*
    Implement pow(x, n).
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        long pn = n < 0 ? -(long)n : n;
        double ret = 1.0;
        while (pn > 1) {
            if ((pn & 1) == 1) {
                ret *= x;
            }
            x *= x;
            pn >>= 1;
        }
        return n < 0 ? 1.0 / (ret * x) : ret * x;
    }
}
