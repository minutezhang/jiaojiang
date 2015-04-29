package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 21, 2013 10:57:38 PM
 */
public class PlusOne {
    /*
    Given a number represented as an array of digits, plus one to the number.
     */

    public static int[] plusOne(int[] digits) {
        int i;
        int[] ret;
        for (i = digits.length - 1; i >= 0 && digits[i] == 9; i--);
        if (i == -1) {
            ret = new int[digits.length + 1];
            ret[0] = 1;
        } else {
            ret = new int[digits.length];
            System.arraycopy(digits, 0, ret, 0, i);
            ret[i] = digits[i] + 1;
        }

        return ret;
    }

    public static void test() {
        int[] ret = plusOne(new int[]{1, 1, 9});
        for (int i : ret) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
