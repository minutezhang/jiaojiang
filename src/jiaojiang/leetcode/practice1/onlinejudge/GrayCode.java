package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: May 5, 2013 10:32:05 PM
 */
public class GrayCode {
    /*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

    For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    00 - 0
    01 - 1
    11 - 3
    10 - 2
    Note:
    For a given n, a gray code sequence is not uniquely defined.

    For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

    For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */

    /*Solution: Assume you have [00, 01, 11, 10], then you have
      00
      01
      11
      10


****  1 + 10
 ***  1 + 11
  **  1 + 01
   *  1 + 00

   *  0 + 00
  **  0 + 01
 ***  0 + 11
****  0 + 10
    please note lines marked by * only differs by the leading bit. Finally you can get the result by shift them
      */
    public static ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            ret.add(0);
            return ret;
        }

        ArrayList<Integer> ret = grayCode(n - 1);
        for (int i = ret.size() - 1; i >= 0; i--) {
            ret.add(ret.get(i) + (int)Math.pow(2, n - 1));
        }
        return ret;
    }

    public static void test() {
        for (int i : grayCode(2)) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        test();
    }
}
