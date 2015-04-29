package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mizhang
 * @time: 3/3/15 3:41 PM
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
        return letterCombinations(digits, 0, getMap());
    }

    private static List<String> letterCombinations(String digits, int start, Map<Character, char[]> map) {
        List<String>  ret = new ArrayList<String>();
        if (start < digits.length()) {
            if (start == digits.length() - 1) {
                for (char c : map.get(digits.charAt(start))) {
                    ret.add(String.valueOf(c));
                }
                return ret;
            }

            for (String s : letterCombinations(digits, start + 1, map)) {
                for (char c : map.get(digits.charAt(start))) {
                    ret.add(c + s);
                }
            }
        }

        return ret;
    }

    public static List<String> letterCombinations2(String digits) {
        return letterCombinations2(digits, 0, getMap());
    }

    private static List<String> letterCombinations2(String digits, int start, Map<Character, char[]> map) {

        if (start == digits.length()) {
            return new ArrayList<String>();
        }

        if (start == digits.length() - 1) {
            List<String> ret = new ArrayList<String>();
            for (char c : map.get(digits.charAt(start))) {
                ret.add(String.valueOf(c));
            }
            return ret;
        }

        char[] letters = map.get(digits.charAt(start));
        List<String> combinations = letterCombinations(digits, start + 1, map);
        int size = combinations.size();

        for (int i = 1; i < letters.length; i++) {
            for (int j = 0; j < size; j++) {
                combinations.add(letters[i] + combinations.get(j));
            }
        }

        for (int i = 0; i < size; i++) {
            combinations.set(i, letters[0] + combinations.get(i));
        }

        return combinations;
    }

    private static Map<Character, char[]> getMap() {
        Map<Character, char[]> n2l = new HashMap<Character, char[]>();
        n2l.put('2', "abc".toCharArray());
        n2l.put('3', "def".toCharArray());
        n2l.put('4', "ghi".toCharArray());
        n2l.put('5', "jkl".toCharArray());
        n2l.put('6', "mno".toCharArray());
        n2l.put('7', "pqrs".toCharArray());
        n2l.put('8', "tuv".toCharArray());
        n2l.put('9', "wxyz".toCharArray());

        return n2l;
    }
}
