package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Oct 25, 2013 11:07:56 PM
 */
public class SingleNumberII {
    /*
    Given an array of integers, every element appears three times except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public static int singleNumber(int[] A) {
        byte[] a = new byte[32];
        for (int i : A) {
            xor3(a, i);
        }

        return getInt(a);
    }

    public static void xor3(byte[] a, int  b) {
        for (int i = 0; i < 32; i++) {
            a[i] = (byte)((a[i] + ((b >>> i) & 1)) % 3);
        }
    }

    public static int getInt(byte[] a) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret |= a[i]<<i;
        }
        return ret;
    }

    public static void test() {
        Utils.printTestln(singleNumber(new int[]{1, 1, 1, 4}), 4);
        Utils.printTestln(singleNumber(new int[]{1, 1, 1, 3, 3, 3, 4}), 4);
    }

    public static void main(String[] args) {
        test();
    }
}
