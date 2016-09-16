package jiaojiang.leetcode.uber.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 14, 2016
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
     */
    public static int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret = ret * 26 + s.charAt(i) - 'A' + 1;
        }
        return ret;
    }
}
