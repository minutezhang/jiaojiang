package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 2, 2013 8:34:23 PM
 */
public class DecodeWays {
    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.
     */
    public static int numDecodings(String s) {
        return s.length() == 0 ? 0 : numDecodings(s, 0);
    }

    public static int numDecodings(String s, int start) {
        if (start == s.length()) {
            return 1;
        }

        if (start == s.length() - 1) {
            return s.charAt(start) == '0' ? 0 : 1;
        }

        char c = s.charAt(start), n = s.charAt(start + 1);
        if ( c > '0' && c <='9') {
            if ( (c - '0') * 10 + n - '0' < 27) {
                return numDecodings(s, start + 1) + numDecodings(s, start + 2);
            } else {
                return numDecodings(s, start + 1);
            }
        }
        return 0;
    }

    public static int numDecodingsDP(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] num = new int[s.length() + 1];
        num[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') {
            num[s.length() - 1] = 1;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i), n = s.charAt(i + 1);
            if (c > '0' && c <= '9') {
                if ( (c - '0') * 10 + n - '0' < 27) {
                    num[i] = num[i + 1] + num[i + 2];
                } else {
                    num[i] = num[i + 1];
                }
            } else {
                num[i] = 0;
            }
        }

        return num[0];
    }

    public static void test() {
        System.out.println(numDecodings("12")); //2
        System.out.println(numDecodings("100")); //0
        System.out.println(numDecodings("27")); //1

        System.out.println(numDecodingsDP("12")); //2
        System.out.println(numDecodingsDP("100")); //0
        System.out.println(numDecodingsDP("27")); //1
    }

    public static void main(String[] args) {
        test();
    }
}
