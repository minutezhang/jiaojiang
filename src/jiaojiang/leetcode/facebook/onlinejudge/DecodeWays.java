package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
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
        if (s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[3];
        dp[1] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[0] = 0;
            } else if (i < s.length() - 1 && (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                dp[0] = dp[1] + dp[2];
            } else {
                dp[0] = dp[1];
            }
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        return dp[0];
    }

    public static int numDecodingsDP(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else if (i < s.length() - 1 && (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static int numDecodingsRecursive(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        return numDecodings(s, 0);
    }

    private static int numDecodings(String s, int start) {
        if (start == s.length()) {
            return 1;
        }

        if (start > s.length() || s.charAt(start) == '0' ) {
            return 0;
        }

        if (start < s.length() - 1 && (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0' <= 26) {
            return numDecodings(s, start + 1) + numDecodings(s, start + 2);
        }

        return numDecodings(s, start + 1);
    }
}
