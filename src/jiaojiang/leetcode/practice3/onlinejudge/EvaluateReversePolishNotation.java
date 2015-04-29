package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Stack;

/**
 * @author: mizhang
 * @time: 2/27/15 10:31 AM
 */
public class EvaluateReversePolishNotation {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                String o2 = stack.pop(), o1 = stack.pop();
                stack.push(String.valueOf(op(o1, o2, tokens[i].toCharArray()[0])));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private static int op(String operand1, String operand2, char operator)  {
        int o1 = Integer.parseInt(operand1), o2 = Integer.parseInt(operand2);
        switch (operator) {
            case '+' : return o1 + o2;
            case '-' : return o1 - o2;
            case '*' : return o1 * o2;
            case '/' : return o1 / o2;
        }

        return 0;
    }
}
