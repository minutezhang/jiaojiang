package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.Stack;

/**
 * @author: zhang
 * @since: Dec 11, 2013 10:12:15 PM
 */
public class EvaluateRPN {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());                
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int oprand = stack.pop();
                stack.push(stack.pop() / oprand);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static void test() {
        Utils.printTestln(evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9);
        Utils.printTestln(evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6);
    }

    public static void main(String[] args) {
        test();
    }
}
