package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @date: Mar 22, 2015 10:10:43 PM
 */
public class IntegerToRoman {
    /*
    Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static String intToRoman(int num) {
        int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer ret = new StringBuffer();

        for (int i = 0; i < bases.length && num > 0; num %= bases[i++]) {
            int repeat = num / bases[i];
            for (int j = 0; j < repeat; j++) {
                ret.append(romans[i]);
            }
        }

        return ret.toString();
    }
}
