package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Jul 27, 2016
 */
public class SumOfTwoInteger {
    /**
     Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

    Example:
    Given a = 1 and b = 2, return 3.
     */
    public static int getSum(int a, int b) {
        for(; b != 0; a ^= b, b = ((a ^ b) & b) << 1);

        return a;
    }
}
