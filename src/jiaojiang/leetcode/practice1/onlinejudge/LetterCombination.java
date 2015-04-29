package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @since: Apr 13, 2013 12:08:12 AM
 */
public class LetterCombination {
    /*
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ret = new ArrayList<String>();
        ret.add("");

        for (char i : digits.toCharArray()) {
            for (int j = 0, n = ret.size(); j < n; j++) {
                String s = ret.get(j);
                char[] chars = mapping[i - '1'].toCharArray();
                for (int k = 1; k < chars.length; k++) {
                    ret.add(s + chars[k]);
                }
                ret.set(j, s + chars[0]);
            }
        }

        return ret;
    }

    public static void printLetterCombinationsHelp(String digits, int index, List<Character> buffer) {
        String[] mapping = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (index == digits.length()) {
            for (char c : buffer) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        for (char c : mapping[digits.charAt(index) - '1'].toCharArray()) {
            buffer.add(c);
            printLetterCombinationsHelp(digits, index + 1, buffer);
            buffer.remove(buffer.size() - 1);
        }
    }

    public static void printLetterCombinations(String digits) {
        printLetterCombinationsHelp(digits, 0, new ArrayList<Character>());
    }

    public static void test() {
        String d = "25";
        for (String s : letterCombinations(d)) {
            System.out.println(s);
        }
        System.out.println("==== print only ====");
        printLetterCombinations(d);
    }

    public static void main(String[] args) {
        test();
    }

}
