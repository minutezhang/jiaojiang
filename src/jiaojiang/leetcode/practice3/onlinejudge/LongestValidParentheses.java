package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/16/15 7:26 PM
 */
public class LongestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.

    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
    */

    public static int longestValidParentheses(String s) {
        int countFromLeft = 0, leftParenthesesCount = 0, rightParenthesesCount = 0, countFromRight = 0, maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countFromLeft++;
                leftParenthesesCount++;
            } else {
                leftParenthesesCount--;
                countFromLeft = leftParenthesesCount >= 0 ? countFromLeft + 1 : 0;
                if (leftParenthesesCount == 0) {
                    maxCount = Math.max(maxCount, countFromLeft);
                }
                leftParenthesesCount = Math.max(leftParenthesesCount, 0);
            }


            if (s.charAt(s.length() - 1 - i) == ')') {
                countFromRight++;
                rightParenthesesCount++;
            } else {
                rightParenthesesCount--;
                countFromRight = rightParenthesesCount >= 0 ? countFromRight + 1 : 0;
                if (rightParenthesesCount == 0) {
                    maxCount = Math.max(maxCount, countFromRight);
                }
                rightParenthesesCount = Math.max(rightParenthesesCount, 0);
            }
        }

        return maxCount;
    }
}
