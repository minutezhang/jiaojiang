package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/5/15 7:48 PM
 */
public class AddBinary {
    /*
    Given two binary strings, return their sum (also a binary string).

    For example,
    a = "11"
    b = "1"
    Return "100".
     */
    public static String addBinary(String a, String b) {
        String ret = "";
        int carrier = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int ai = i < 0 ? 0 : a.charAt(i) - '0', bi = j < 0 ? 0: b.charAt(j) - '0';
            int sum = ai + bi + carrier;
            if (sum > 1) {
                sum = sum & 1;
                carrier = 1;
            } else {
                carrier = 0;
            }
            ret = (char)(sum + '0') + ret;
        }

        if (carrier == 1) {
            ret = '1' + ret;
        }

        return ret;
    }
}
