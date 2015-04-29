package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: mizhang
 * @time: 2/14/15 11:37 PM
 */
public class FractionToRecurringDecimal {
    /*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.

    For example,

    Given numerator = 1, denominator = 2, return "0.5".
    Given numerator = 2, denominator = 1, return "2".
    Given numerator = 2, denominator = 3, return "0.(6)".
    Credits:
    Special thanks to @Shangrila for adding this problem and creating all test cases.
     */

    //Please NOTE, the length of recurring decimal should not exceed value of denominator
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuffer integer = new StringBuffer();
        if (Integer.signum(numerator) * Integer.signum(denominator) < 0) {
            integer.append('-');
        }

        long longNumerator = Math.abs((long)numerator);
        long longDenominator = Math.abs((long)denominator);

        integer.append(longNumerator / longDenominator);
        longNumerator %= longDenominator;

        Map<Long, Integer> remainders = new HashMap<Long, Integer>();
        StringBuffer decimal = new StringBuffer();

        for (int i = 0; !remainders.containsKey(longNumerator) && longNumerator != 0; i++) {
            remainders.put(longNumerator, i);
            longNumerator *= 10;
            decimal.append(longNumerator / longDenominator);
            longNumerator %= longDenominator;
        }

        if (longNumerator == 0) {
            return decimal.length() == 0 ? integer.toString() : integer.append('.').append(decimal).toString();
        }

        decimal.insert((int)remainders.get(longNumerator), '(');
        integer.append('.').append(decimal).append(')');

        return integer.toString();
    }
}
