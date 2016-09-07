package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
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
        int carrier = 0, i, j;
        String ret = "";
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carrier > 0; i--, j--) {
            int ai = i >= 0 ? a.charAt(i) - '0' : 0, bj = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = ai + bj + carrier;
            carrier = (sum >> 1) & 1;
            ret = (sum & 1) + ret;
        }

        return ret;
    }
}
