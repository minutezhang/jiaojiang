package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 22, 2016
 */
public class SingleNumberIII {
    /*
    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
    exactly twice. Find the two elements that appear only once.

    For example:

    Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

    Note:

        The order of the result is not important. So in the above example, [5, 3] is also correct.
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space
        complexity?

    Solution:

    In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that
    since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result.
    Find out an arbitrary set bit (for example, the rightmost set bit).

    In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the
    aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR
    numbers in each group, we can find a number in either group.
     */
    public static int[] singleNumber(int[] nums) {
        int xor = 0, xor2 = 0;
        for (int n : nums) {
            xor ^= n;
        }

        int lowbit = xor & -xor;

        xor = 0;
        for (int n : nums) {
            if ((n & lowbit) == 0) {
                xor ^= n;
            } else {
                xor2 ^= n;
            }
        }

        return new int[]{xor, xor2};
    }
}
