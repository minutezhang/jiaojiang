package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Apr 19, 2016
 */
public class PowerOfFour {
    /*
     Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

    Example:
    Given num = 16, return true. Given num = 5, return false.

    Follow up: Could you solve it without loops/recursion?
     */
    public static boolean isPowerOfFour(int num) {
        return (num - 1 & num) == 0 && (num & 0x55555555) != 0; 
    }
}
