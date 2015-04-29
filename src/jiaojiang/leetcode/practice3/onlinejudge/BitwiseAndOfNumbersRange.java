package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Apr 23, 2015 9:13:36 PM
 */
public class BitwiseAndOfNumbersRange {
    /*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    For example, given the range [5, 7], you should return 4.
     */
    public static int rangeBitwiseAnd(int m, int n) {
        for (int i = m + 1; i > 0 && i <= n && m != 0; m &= i, i++);

        return m;
    }

    public static int rangeBitwiseAnd2(int m, int n) {
        for (; n > m; n &= n - 1);

        return m & n;
    }
}
