package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 19, 2016
 */
public class AddDigits {
    /*
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    For example:

    Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

    Follow up:
    Could you do it without any loop/recursion in O(1) runtime?

    Hint:

        A naive implementation of the above process is trivial. Could you come up with other methods?
        What are all the possible results?
        How do they occur, periodically or randomly?
        You may find this Wikipedia article useful: https://en.wikipedia.org/wiki/Digital_root
     */
    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public static int addDigits2(int num) {
        while (num >= 10) {
            int ret = 0;
            while (num > 0) {
                ret += num%10;
                num /= 10;
            }
            num = ret;
        }
        return num;
    }
}
