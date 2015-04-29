package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @since: May 12, 2013 12:21:48 AM
 */
public class ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public static boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        Map<Character, Character> match = new HashMap<Character, Character>();
        match.put(']', '[');
        match.put(')', '(');
        match.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                parentheses.add(c);
            } else if (parentheses.isEmpty() || parentheses.pop() != match.get(c)) {
                return false;
            }
        }

        return parentheses.isEmpty();
    }

    public static void test() {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(}")); // false
        System.out.println(isValid("[({(())}[()])]")); // true
    }

    public static void main(String[] args) {
        test();
    }
}
