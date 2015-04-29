package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/17/15 11:18 PM
 */
public class StrStr {
    /*
    mplement strStr().

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Update (2014-11-02):
    The signature of the function had been updated to return the index instead of the pointer. If you still see
    your function signature returns a char * or String, please click the reload button  to reset your code definition.
     */
    public static int strStr(String haystack, String needle) {
//        if (needle == null || needle.length() == 0) {
//            return 0;
//        }
//
//        String nh = needle + haystack;
//        int[] borderWidth = new int[nh.length()]; // all initialized to 0
//
//        for (int i = 1; i < borderWidth.length; i++) {
//            for (int j = i; j > 0; j = borderWidth[j - 1]) {
//                if (nh.charAt(borderWidth[j - 1]) == nh.charAt(i)) {
//                    borderWidth[i] = borderWidth[j - 1] + 1;
//                    break;
//                }
//            }
//            if (i >= (needle.length() * 2 - 1) && borderWidth[i] >= needle.length()) {
//                return i + 1 - 2 * needle.length();
//            }
//        }
//
//        return -1;

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int[] borderWidth = new int[needle.length()]; // all initialized to 0

        for (int i = 1; i < borderWidth.length; i++) {
            for (int j = i; j > 0; j = borderWidth[j - 1]) {
                if (needle.charAt(borderWidth[j - 1]) == needle.charAt(i)) {
                    borderWidth[i] = borderWidth[j - 1] + 1;
                    break;
                }
            }
        }

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && (needle.charAt(j) != haystack.charAt(i))) {
                j = borderWidth[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }
}
