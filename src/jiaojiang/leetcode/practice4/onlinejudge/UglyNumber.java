package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class UglyNumber {
    /*
     Write a program to check whether a given number is an ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14
    is not ugly since it includes another prime factor 7.

    Note that 1 is typically treated as an ugly number.
     */
    public static boolean isUgly(int num) {
        int preNum;
        do {
            preNum = num;
            if ((num & 1) == 0) {
                num >>= 1;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            }
        } while (preNum > num);
        return num == 1;
    }
}
