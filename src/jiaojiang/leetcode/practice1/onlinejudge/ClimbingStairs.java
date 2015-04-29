package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 28, 2013 11:54:15 PM
 */
public class ClimbingStairs {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        int fn1 = 1, fn2 = 1, fn = 1;
        for (int i = 1; i < n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }

        return fn;
    }

}
