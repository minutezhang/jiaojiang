package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/28/15 1:34 PM
 */
public class PalindromeNumber {
    /*
    Determine whether an integer is a palindrome. Do this without extra space.

    click to show spoilers.

    Some hints:
    Could negative integers be palindromes? (ie, -1)

    If you are thinking of converting the integer to string, note the restriction of using extra space.

    You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that
    the reversed integer might overflow. How would you handle such case?

    There is a more generic way of solving this problem.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int oneStep = x, reversed = 0, twoStep = x;
        for(; twoStep / 10 > 0; reversed = reversed * 10 + oneStep % 10, twoStep /= 100, oneStep /= 10);

        return (twoStep > 0 ? oneStep / 10 : oneStep) == reversed;
    }
}
