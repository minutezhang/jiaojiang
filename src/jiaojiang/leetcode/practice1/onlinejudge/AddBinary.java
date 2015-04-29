package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 15, 2013 10:42:24 PM
 */
public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).
        For example,
            a = "11"
            b = "1"
        Return "100".
     */

    public static String addBinary(String a, String b) {
        int carrier = 0, index;
        String l, s;

        if (a.length() > b.length()) {
            l = a;
            s = b;
        } else {
            l = b;
            s = a;
        }

        char[] ret = new char[l.length() + 1];
        for (index = 1; index <= s.length(); index++) {
            ret[ret.length - index] = (char)('0' + (l.charAt(l.length() - index) ^ s.charAt(s.length() - index) ^ carrier));
            carrier = l.charAt(l.length() - index) +  s.charAt(s.length() - index) + carrier >= '1' + '1' ? 1 : 0;
        }

        for ( ; index <= l.length(); index++) {
            ret[ret.length - index] = (char)('0' + (l.charAt(l.length() - index) ^ '0' ^ carrier));
            carrier = l.charAt(l.length() - index) + carrier > '1' ? 1 : 0;
        }

        if (carrier == 1) {
            ret[0] = '1';
            return new String(ret);
        }

        return new String(ret, 1, ret.length - 1);
    }

    public static void test() {
        System.out.println(addBinary("11", "1"));
    }

    public static void main(String[] args) {
//        System.out.printTestln((char)('0' + ('1' ^ '1')));
//        System.out.printTestln((char)('0' + ('1' ^ '0')));
//        System.out.printTestln((char)('0' + ('0' ^ '0')));
        test();
    }
}
