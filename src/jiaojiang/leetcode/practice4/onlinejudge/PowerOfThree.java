package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class PowerOfThree {
    /*
     Given an integer, write a function to determine if it is a power of three.

    Follow up:
    Could you do it without using any loop / recursion?
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
