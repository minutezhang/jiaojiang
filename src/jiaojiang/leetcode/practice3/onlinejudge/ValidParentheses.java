package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Stack;

/**
 * @author: mizhang
 * @time: 2/10/15 11:14 PM
 */
public class ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || !doesMatch(stack.pop(), s.charAt(i))) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeft(char p) {
        return p == '{' || p == '[' || p == '(';
    }

    private static boolean doesMatch(char leftP, char rightP) {
        switch(leftP) {
            case '{': return rightP == '}';
            case '[': return rightP == ']';
            case '(': return rightP == ')';
        }
        return false;
    }
}
