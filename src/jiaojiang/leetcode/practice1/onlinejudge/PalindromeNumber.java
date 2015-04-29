package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Jun 3, 2013 10:02:02 PM
 */
public class PalindromeNumber {
    /*
    Determine whether an integer is a palindrome. Do this without extra space.
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

        int reverse = 0, number = x;
        while (number > 0 ) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }

        return x == reverse;
    }

    public static void test() {
        System.out.println(isPalindrome(123)); //false
        System.out.println(isPalindrome(12321)); //true
        System.out.println(isPalindrome(-101));  //false
    }

    public static void main(String[] args) {
        test();
    }

    
}
