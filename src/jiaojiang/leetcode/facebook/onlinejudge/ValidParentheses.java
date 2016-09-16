package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
    valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            switch(c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
