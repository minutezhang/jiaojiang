package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 14, 2013 10:01:58 PM
 */
public class LongestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
    parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.

    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */
    public static int longestValidParentheses(String s) {
        int leftPair = 0, rightPair = 0, leftCount = 0, rightCount = 0, max = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
                leftPair++;
            } else {
                leftCount++;
                leftPair--;
            }

            if (leftPair == 0) {
                max = Math.max(leftCount, max);
            } else if (leftPair < 0) {
                leftPair = 0;
                leftCount = 0;
            }

            if (s.charAt(n - i - 1) == ')') {
                rightCount++;
                rightPair++;
            } else {
                rightCount++;
                rightPair--;
            }

            if (rightPair == 0) {
                max = Math.max(rightCount, max);
            } else if (rightPair < 0) {
                rightPair = 0;
                rightCount = 0;
            }
        }

        return max;
    }

    public static void test() {
        System.out.println(longestValidParentheses(")()())"));  //4
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));  //22
        System.out.println(longestValidParentheses("()(()"));  //2
    }

    public static void main(String[] args) {
        test();
    }
}
