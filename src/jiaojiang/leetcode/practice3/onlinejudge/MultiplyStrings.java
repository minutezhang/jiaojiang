package jiaojiang.leetcode.practice3.onlinejudge;

import jiaojiang.leetcode.practice1.onlinejudge.String2Int;

/**
 * @author: mizhang
 * @time: 2/2/15 11:47 AM
 */
public class MultiplyStrings {
    /*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
     */
    public static String multiply(String num1, String num2) {
        char[] ret = new char[num1.length() + num2.length()];
        char[] prod = new char[num1.length() + 1];
        int length = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            int l = multiplyHelp(num1, num2.charAt(i), prod);
            length = add(ret, length, prod, l, num2.length() - i - 1);
        }

        length = trimZeros(ret, length);

        return new String(ret, ret.length - length, length);
    }

    private static int trimZeros(char[] result, int length) {
        for (; length > 1 && result[result.length - length] == '0'; length--);
        return length;
    }


    private static int multiplyHelp(String num1, char digit, char[] prod) {
        int index, carryOver;
        for (index = 0, carryOver = 0; index < num1.length(); index++) {
            int p = (num1.charAt(num1.length() - index - 1) - '0') * (digit - '0') + carryOver;
            if (p > 9) {
                carryOver = p / 10;
                p %= 10;
            } else {
                carryOver = 0;
            }
            prod[prod.length - index - 1] = (char)(p + '0');
        }

        if (carryOver > 0) {
            prod[prod.length - index++ - 1] = (char) (carryOver + '0');
        }

        return index;
    }

    private static int add(char[] result, int length, char[] num, int length2, int shiftBit) {
        //padding 0's
        for (int i = length + 1; i <= shiftBit; i++) {
            result[result.length - i] = '0';
        }

        int index, carryOver;
        for (index = shiftBit, carryOver = 0; index < length || index < length2 + shiftBit; index++) {
            int sum = carryOver;
            if (index < length) {
                sum += result[result.length - index - 1] - '0';
            }

            if (index < length2 + shiftBit) {
                sum += num[num.length - index - 1 + shiftBit] - '0';
            }

            if (sum > 9) {
                carryOver = 1;
                sum -= 10;
            } else {
                carryOver = 0;
            }

            result[result.length - index - 1] = (char)(sum + '0');
        }

        if (carryOver == 1) {
            result[result.length - index - 1] = '1';
            index++;
        }

        return index;
    }
}
