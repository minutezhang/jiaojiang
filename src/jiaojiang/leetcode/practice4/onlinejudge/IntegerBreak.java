package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Apr 19, 2016
 */
public class IntegerBreak {
    /*
     Given a positive integer n, break it into the sum of at least two positive integers and maximize the product
     of those integers. Return the maximum product you can get.

    For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

    Note: you may assume that n is not less than 2.

    Hint:

        There is a simple O(n) solution to this problem.
        You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
     */
    public static int integerBreak(int n) {
        int max = 1;
        for (int i = 2; i < n; i++) {
            max = Math.max(max, Math.max(i * integerBreak(n - i), i * (n - i)));
        }

        return max;
    }

    public static int integerBreakMem(int n) {
        return integerBreakMem(n, new int[n]);
    }

    private static int integerBreakMem(int n, int[] mem) {
        if (mem[n - 1] != 0) {
            return mem[n - 1];
        }

        mem[n - 1] = 1;
        for (int i = 2; i < n; i++) {
            mem[n - 1] = Math.max(mem[n - 1], Math.max(i * integerBreakMem(n - i, mem), i * (n - i)));
        }

        return mem[n - 1];
    }


    public static int integerBreakDp(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i + 1 - j)));
            }
        }
        return dp[n - 1];
    }
}
