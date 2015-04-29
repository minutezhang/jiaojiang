package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/12/15 4:15 PM
 */
public class FactorialTrailingZeroes {
    /*
    Given an integer n, return the number of trailing zeroes in n!.

    Note: Your solution should be in logarithmic time complexity.

    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while ((n /= 5) >= 1) {
            count += n;
        }

        return count;
    }
}
