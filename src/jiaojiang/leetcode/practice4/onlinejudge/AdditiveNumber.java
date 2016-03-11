package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Feb 26, 2016
 */
public class AdditiveNumber {
    /*
    Additive number is a string whose digits can form additive sequence.

    A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
    number in the sequence must be the sum of the preceding two.

    For example:
    "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

    1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

    "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

    1 + 99 = 100, 99 + 100 = 199

    Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

    Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

    Follow up:
    How would you handle overflow for very large input integers?
     */
    public static boolean isAdditiveNumber(String num) {
        int l = (int)Math.ceil(num.length() / 3.0);

        for (int i = 1; i <= l; i++) {
            for (int j = i + 1; j <= num.length() - l; j++) {
                if (isAdditiveNumber(num, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    
    private static boolean isAdditiveNumber(String num, int start, int mid, int end) {
        if (end == num.length()) {
            return true;
        }

        if (num.charAt(start) == '0' && mid - start != 1 || num.charAt(mid) == '0' && end - mid != 1) {
            return false;
        }

        long a = Long.parseLong(num.substring(start, mid));
        long b = Long.parseLong(num.substring(mid, end));

        if (num.charAt(end) == '0') {
            return a + b == 0;
        }

        long c = 0;
        for (int i = end; i < num.length(); i++) {
            c = c * 10 + num.charAt(i) - '0';
            if ( a + b == c) {
                return isAdditiveNumber(num, mid, end, i + 1);
            }
            if (a + b < c) {
                return false;
            }
        }

        return false;
    }
}
