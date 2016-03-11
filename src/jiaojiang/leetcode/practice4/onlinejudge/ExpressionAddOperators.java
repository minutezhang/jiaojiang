package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Mar 6, 2016
 */
public class ExpressionAddOperators {
    /*
     Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
     (not unary) +, -, or * between the digits so they evaluate to the target value.

    Examples:

    "123", 6 -> ["1+2+3", "1*2*3"]
    "232", 8 -> ["2*3+2", "2+3*2"]
    "105", 5 -> ["1*0+5","10-5"]
    "00", 0 -> ["0+0", "0-0", "0*0"]
    "3456237490", 9191 -> []
     */
    public static List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();

        addOperators(num, 0, null, target, ret, "");
        for (String s : ret) {
            System.out.println(s);
        }
        return ret;
    }

    private static void addOperators(String num, int start, Integer currentValue, int target, List<String> ret, String buf) {
//        System.out.println(target  + ": " + buf + " : " + start);

        if (start == num.length()) {
            if (target == 0) {
                ret.add(buf);
            }
            return;
        }

        char c = num.charAt(start);
        int v = c - '0';

        if (currentValue != null && currentValue == 0 && c == '0') {
            return;
        }

        if (currentValue == null) {
            currentValue = 0;
        }
        int newValue = currentValue * 10 + v;
//        System.out.println(newValue + " : " + "".equals(buf));
        addOperators(num, start + 1, null, target - newValue, ret, buf + ("".equals(buf) ? "" : "+") + newValue);
        addOperators(num, start + 1, null, target + newValue, ret, buf + "-" + newValue);
        addOperators(num, start + 1, null, target - (currentValue * v), ret, buf + ("".equals(buf) ? "" : "+") + currentValue + "*" + c);
        addOperators(num, start + 1, null, target + (currentValue * v), ret, buf + "-" + currentValue + "*" + c);
        addOperators(num, start + 1, newValue, target, ret, buf);
    }
}
