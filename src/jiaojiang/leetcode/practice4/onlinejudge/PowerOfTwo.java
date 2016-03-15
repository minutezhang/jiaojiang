package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class PowerOfTwo {
    /*
    Given an integer, write a function to determine if it is a power of two.
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
