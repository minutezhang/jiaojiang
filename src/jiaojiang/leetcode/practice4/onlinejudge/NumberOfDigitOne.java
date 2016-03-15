package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class NumberOfDigitOne {
    /*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    For example:
    Given n = 13,
    Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

    Hint:

        Beware of overflow.
     */

    /*
    NOTE: XYZ, if X = 1, then it has YZ options, if Y = 1, then it has XZ options, if Z = 1, it has XY options.
    so, totally is XY + XZ + YZ.
    Consider the cases : 205, 215, 225 when working on the 2nd digits  (0, 1, 2 respectively)
     */
    public static int countDigitOne(int n) {
        int total = 0;
        for (long multiplier = 1; n >= multiplier; multiplier *= 10) {
            long highBits = n / multiplier;
            long remainder = n % multiplier;
            long digit = highBits % 10;
            long count;
            if (digit < 1) {
                count = highBits / 10 * multiplier;
            } else if (digit == 1) {
                count = highBits / 10 * multiplier + remainder + 1;
            } else {
                count = (highBits / 10  + 1) * multiplier;
            }
            total += count;
        }
        return total;
    }
}
