package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Mar 12, 2016
 */
public class BasicCalculator {
    /*
    implement a basic calculator to evaluate a simple expression string.

    The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative
    integers and empty spaces .

    You may assume that the given expression is always valid.

    Some examples:

    "1 + 1" = 2
    " 2-1 + 2 " = 3
    "(1+(4+5+2)-3)+(6+8)" = 23
     */
    public static int calculate(String s) {
        Stack<Boolean> isNegative = new Stack<Boolean>();

        boolean shouldNegate = false, negativeOperator = false;
        int result = 0, operand = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c <= '9' && c >= '0') {
                operand = operand * 10 + c - '0';
            } else {
                result += shouldNegate ^ negativeOperator ? -operand : operand;
                operand = 0;
                switch (c) {
                    case '(' :
                        shouldNegate = isNegative.push(negativeOperator) ^ shouldNegate;
                        negativeOperator = false;
                        break;
                    case ')' :
                        shouldNegate = isNegative.pop() ? !shouldNegate : shouldNegate;
                        break;
                    case '-' :
                        negativeOperator = true;
                        break;
                    case '+' :
                        negativeOperator = false;
                        break;
                }
            }
        }

        return result += shouldNegate ^ negativeOperator ? -operand : operand;
    }
}
