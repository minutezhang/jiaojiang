package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/27/15 9:57 PM
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
}
