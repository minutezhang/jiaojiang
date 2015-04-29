package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Oct 25, 2013 11:00:31 PM
 */
public class SingleNumber {
    /*
    Given an array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */

    public static int singleNumber(int[] A) {
        int ret = 0;
        for (int i : A) {
            ret ^= i;
        }

        return ret;
    }

    public static void test(){
        Utils.printTestln(singleNumber(new int[]{1, 3, 5, 9, 7, 1, 3, 5, 9}), 7);
    }

    public static void main(String[] args) {
        test();
    }
}
