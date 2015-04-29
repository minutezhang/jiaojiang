package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * @author: mizhang
 * @since: Dec 3, 2014 12:52:02 PM
 */
public class DivideTwoIntegers {
    /*
    Divide two integers without using multiplication, division and mod operator.
     */
    public static int divide(int dividend, int divisor) {
        long divisorP = Math.abs((long)divisor), dividendP = Math.abs((long)dividend);
        int ret = 0, shiftBits;

        while (dividendP >= divisorP) {
            for (shiftBits = 0; (divisorP << (shiftBits + 1)) <= dividendP; shiftBits++);
            ret += (1 << shiftBits);
            dividendP -= (divisorP << shiftBits);
        }

        if (divisor < 0 && dividend < 0 || divisor > 0 && dividend > 0) {
            return ret;
        }
        return -ret;
    }

    public static void test() {
        Test.assertEquals(3, divide(10, 3));
        Test.assertEquals(3, divide(11, 3));
        Test.assertEquals(4, divide(12, 3));
        Test.assertEquals(-4, divide(-12, 3));
        Test.assertEquals(1, divide(Integer.MAX_VALUE, Integer.MAX_VALUE - 1));
        Test.assertEquals(0, divide(-1010369383, -2147483648));
    }

    public static void main(String[] args) {
        test();
    }
}
