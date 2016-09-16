package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class LetterCombinationsOfAPhoneNumber {
    /*
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
     */
    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> digitLettersMap = new HashMap<Integer, String>();
        digitLettersMap.put(2, "abc");
        digitLettersMap.put(3, "def");
        digitLettersMap.put(4, "ghi");
        digitLettersMap.put(5, "jkl");
        digitLettersMap.put(6, "mno");
        digitLettersMap.put(7, "pqrs");
        digitLettersMap.put(8, "tuv");
        digitLettersMap.put(9, "wxyz");

        List<String> ret = new ArrayList<String>();
        letterCombinations(digits, 0, "", ret, digitLettersMap);
        return ret;
    }

    private static void letterCombinations(String digits,
                                           int start,
                                           String prefix,
                                           List<String> buffer,
                                           Map<Integer, String> digitLettersMap) {
        if (start == digits.length()) {
            if (!prefix.isEmpty()) {
                buffer.add(prefix);
            }
            return;
        }

        for (char c : digitLettersMap.get(digits.charAt(start) - '0').toCharArray()) {
            letterCombinations(digits, start + 1, prefix + c, buffer, digitLettersMap);
        }
    }
}
