package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Jun 3, 2013 11:46:21 PM
 */
public class StrStr {
    /*
    Implement strStr().

    Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
     */
    public static String strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++);
            if (j == needle.length()) {
                return haystack.substring(i);
            }
        }

        return null;
    }


}
