package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/8/15 10:05 AM
 */
public class ReverseInteger {
    /*
    Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321

    click to show spoilers.

    Have you thought about this?
    Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of
    1000000003 overflows. How should you handle such cases?

    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    Update (2014-11-10):
    test cases had been added to test the overflow behavior.
     */
    public static int reverse(int x) {
        long ret = 0, l = Math.abs(x);
        for (; l != 0; l /= 10) {
            ret = (l % 10) + ret * 10;
        }
        ret = x < 0 ? -ret : ret;

        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 0 : (int)ret;
    }
}