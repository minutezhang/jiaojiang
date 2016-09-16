package jiaojiang.leetcode.uber.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 15, 2016
 */
public class GenerateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ]
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        generateParenthesis(n, 0, 0, "", ret);
        return ret;
    }

    private static void generateParenthesis(int n, int left, int right, String prefix, List<String> ret) {
        if (right > left || left > n) {
            return;
        }

        if (right == n) {
            ret.add(prefix.toString());
        } else if (left == n) {
            generateParenthesis(n, left, right + 1, prefix + ")", ret);
        } else {
            generateParenthesis(n, left + 1, right, prefix + "(", ret);
            generateParenthesis(n, left, right + 1, prefix + ")", ret);
        }
    }
}
