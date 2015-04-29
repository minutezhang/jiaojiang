package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 14, 2013 1:54:36 AM
 */
public class Pow {
    /*
    Implement pow(x, n).
     */
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double ret = 1, base = x;
        long exponent = n >= 0 ? n : -(long)n;         // please note, exponent is long to avoid overflow since ABS of Integer.MAX_VAULE and Integer.MIN_VALUE differs

        while (exponent > 1) {
            if ( (exponent & 1) == 1) {
                ret *= base;
            }

            base *= base;
            exponent >>= 1;
        }

        ret *= base;

        return n >= 0 ? ret : 1.0 / ret;
    }

    public static void  testPow() {
        System.out.println(pow(3.0, 2));
        System.out.println(pow(3.0, 4));
        System.out.println(pow(-1.00000, -2147483648));
    }

    public static void main(String[] args) {
        testPow();
    }
}
