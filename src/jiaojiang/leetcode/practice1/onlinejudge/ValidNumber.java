package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 16, 2013 10:15:46 PM
 */
public class ValidNumber {
    /*
    Validate if a given string is numeric.

    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true

    Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
    */
    public static boolean isNumber(String s) {
        int start = 0, end = s.length() - 1, nPoint = 0;

        for ( ; end >= 0 && s.charAt(end) == ' '; end--);
        for ( ; start <= end && s.charAt(start) == ' '; start++);

        if (start == end + 1) {
            return false;
        }

        if ((s.charAt(end) < '0' || s.charAt(end) > '9') && s.charAt(end) != '.') {
            return false;
        }

        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }

        if (start == end + 1) {
            return false;
        }

        if (s.charAt(start) == '.') {
            start++;
            nPoint++;
        }

        if (start == end + 1) {
            return false;
        }

        for ( ; end >= start && s.charAt(end) <= '9' && s.charAt(end) >= '0'; end--);
        if (start == end + 1) {
            return true;
        }

        if (start == end) {
            return false;
        }

        if (s.charAt(end) == 'e') {
            end--;
        } else if (s.substring(end - 1, end + 1).equals("e+") || s.substring(end - 1, end + 1).equals("e-")) {
            end -= 2;
        }

        if (end < 0) {
            return false;
        }

        while (end >= start) {
            if (s.charAt(end) == '.') {
                nPoint++;
                if (nPoint > 1) {
                    return false;
                }
            } else if (s.charAt(end) > '9' || s.charAt(end) < '0') {
                return false;
            }
            end--;
        }

        return true;
    }

    public static void test() {
        System.out.println(isNumber("0"));  //true
        System.out.println(isNumber("0.1")); //true
        System.out.println(isNumber("abc")); //false
        System.out.println(isNumber("1 a")); //false
        System.out.println(isNumber("2e10")); //true
        System.out.println(isNumber("    ")); //false
        System.out.println(isNumber("+")); //false
        System.out.println(isNumber("-")); //false
        System.out.println(isNumber("-.1")); //true
        System.out.println(isNumber("a")); //false
        System.out.println(isNumber("1e")); //false
        System.out.println(isNumber("e+3")); //false
        System.out.println(isNumber("e-3")); //false
    }

    public static void main(String[] args) {
        test();
    }
}
