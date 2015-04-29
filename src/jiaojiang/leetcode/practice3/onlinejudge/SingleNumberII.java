package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 22, 2015 12:21:28 AM
 */
public class SingleNumberII {
    /*
     Given an array of integers, every element appears three times except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public static int singleNumber(int[] A) {
        long ret = 0;
        for (int i : A) {
            ret = xor3(ret, i);
        }
        return (int)(ret & 0xffffffff);
    }

    private static long xor3(long li, int j) {
        long ret = 0, lj = j & 0xffffffffL;
        
        if (li == 0 || lj == 0) {
            return li + lj;
        }

        for(long base = 1; li != 0 || lj != 0; li /= 3, lj /= 3, base *=3) {
            ret += ((li % 3 + lj % 3) % 3) * base;
        }

        return ret;
    }
}
