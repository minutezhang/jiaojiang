package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/14/15 10:45 PM
 */
public class ExcelSheetColumnNumber {
    /*
    Related to question Excel Sheet Column Title

    Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret = ret * 26 + (s.charAt(i) - 'A' + 1);
        }
        return ret;
    }
}
