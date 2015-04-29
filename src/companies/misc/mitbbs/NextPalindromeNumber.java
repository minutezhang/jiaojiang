package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Nov 22, 2013 2:17:50 PM
 */
public class NextPalindromeNumber {
    /*
    Given a number, find the next smallest palindrome number. For example, given 12, the next samllet palindrome number
    is 22. Assume the input is positive, otherwise, the next palindrome number is always 0

    Solution: for example, 19999
    split into two parts 19 - 9 - 99
    then we have 19 - 9 - 91 is palindrom, but it is less than 19999. Then we should add 1 to the middle 9, 19 - (9) - 99
    we got, 20 - 0 - 99, conver to 20 - 0 - 02
     */
    public static int nextPalindrom(int n) {
        int length, number;
        for(length = 0, number = n; number != 0; length++, number /= 10);

        int mask = 1;
        for (int i = 0; i < (length >> 1); i++) {
            mask *= 10;
        }

        number = n / mask;
        int palindrom = 0;
        for(int tmp = (length & 1) == 1 ? number / 10 : number; tmp != 0; palindrom = palindrom * 10 + tmp % 10, tmp /= 10);

        if (palindrom <= n % mask) {
            number++;
        }

        for (palindrom = number, number = (length & 1) == 1 ? number /= 10 : number; number != 0; palindrom = palindrom * 10 + number % 10, number /= 10);

        return palindrom;
    }

    private static void test() {
        int[] numbers = new int[] { 85940359, 85946359, 1749577, 1749377, 199, 1999, 1091, 129913, 28492 };

        for (int n : numbers) {
            Utils.printTestln(nextPalindrom(n), nextPalindrom2(n));
        }
    }

    public static int nextPalindrom2(int n) {
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (isPalindrom(i)) {
                return i;
            }
        }

        return -1;
    }

    //assume n is always greater than 0
    private static boolean isPalindrom(int n) {
        int number = n, target = 0;
        while (number != 0 ) {
            target = target * 10 + number % 10;
            number /= 10;
        }

        return n == target;
    }

    public static void main(String[] args) {
        test();
    }

}
