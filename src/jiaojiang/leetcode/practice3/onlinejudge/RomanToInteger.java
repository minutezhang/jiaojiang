package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @date: Mar 22, 2015 9:54:39 PM
 */
public class RomanToInteger {
    /*
    Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int number = 0, preNumber = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int n = map.get(s.charAt(i));
            number += n < preNumber ? -n : n;
            preNumber = n;
        }

        return number;
    }
}
