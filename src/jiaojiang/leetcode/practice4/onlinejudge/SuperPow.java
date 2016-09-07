package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 5, 2016
 */
public class SuperPow {
    /**
    Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
     given in the form of an array.

    Example1:

    a = 2
    b = [3]

    Result: 8

    Example2:

    a = 2
    b = [1,0]

    Result: 1024
     */
    public static int superPow(int a, int[] b) {
        int ret = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            ret = ret * pow(a, b[i]) % 1337;
            a = pow(a, 10);
        }
        return ret;
    }

    private static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        a %= 1337;
        int ret = 1;
        while (b > 1) {
            if ((b & 1) == 1) {
                ret = ret * a % 1337;
            }
            a = a * a % 1337;
            b >>= 1;
        }
        return ret * a % 1337;
    }
}
