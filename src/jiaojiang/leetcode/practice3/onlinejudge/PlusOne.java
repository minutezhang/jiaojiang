package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/6/15 5:06 PM
 */
public class PlusOne {
    /*
    Given a non-negative number represented as an array of digits, plus one to the number.

    The digits are stored such that the most significant digit is at the head of the list.
     */
    public static int[] plusOne(int[] digits) {
        int index;
        int[] copied = new int[digits.length];
        System.arraycopy(digits, 0, copied, 0, copied.length);

        for (index = copied.length - 1; index >= 0 && copied[index] == 9; copied[index] = 0, index--);

        if (index == -1) {
            int[] ret = new int[copied.length + 1];
            ret[0] = 1;
            return ret;
        } else {
            copied[index]++;
            return copied;
        }
    }
}
