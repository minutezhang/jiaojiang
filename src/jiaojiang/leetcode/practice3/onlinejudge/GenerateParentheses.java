package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/9/15 4:33 PM
 */
public class GenerateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        List<Integer> diffs = new ArrayList<Integer>();

        ret.add("");
        diffs.add(0);

        for (int i = 0; i < n << 1; i++) {
            for (int j = 0, s = ret.size(); j < s; j++) {
                int diff = diffs.get(j);
                String p = ret.get(j);
                boolean hasSet = false;
                if ((diff + i) / 2 < n) {
                    ret.set(j, p + "(");
                    diffs.set(j, diff + 1);
                    hasSet = true;
                }
                if (diff > 0) {
                    if (hasSet) {
                        ret.add(p + ")");
                        diffs.add(diff - 1);
                    } else {
                        ret.set(j, p + ")");
                        diffs.set(j, diff - 1);
                    }
                }
            }
        }

        return ret;
    }

    public static List<String> generateParenthesis2(int n) {
        LinkedList<String> ret = new LinkedList<String>();
        LinkedList<Integer> diffs = new LinkedList<Integer>();
        ret.add("");
        diffs.add(0);

        for (int i = 0; i < (n << 1); i++) {
            for (int j = 0, s = ret.size(); j < s; j++) {
                int diff = diffs.removeFirst();
                String p = ret.removeFirst();
                if (((diff + i) >> 1) < n) {
                    ret.add(p + "(");
                    diffs.add(diff + 1);
                }

                if (diff > 0) {
                    ret.add(p + ")");
                    diffs.add(diff - 1);
                }
            }
        }

        return ret;
    }
}