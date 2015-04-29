package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/14/15 11:08 PM
 */
public class CompareVersionNumbers {
    /*
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

    You may assume that the version strings are non-empty and contain only digits and the . character.
    The . character does not represent a decimal point and is used to separate number sequences.
    For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision
    of the second first-level revision.

    Here is an example of version numbers ordering:

    0.1 < 1.1 < 1.2 < 13.37
    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static int compareVersion(String version1, String version2) {
        String[] vNumber1 = version1.split("\\.");
        String[] vNumber2 = version2.split("\\.");

        int i;
        for (i = 0; i < vNumber1.length && i < vNumber2.length; i++) {
            if (Integer.parseInt(vNumber1[i]) != Integer.parseInt(vNumber2[i])) {
                return Integer.signum(Integer.parseInt(vNumber1[i]) - Integer.parseInt(vNumber2[i]));
            }
        }

        for (; i < vNumber1.length; i++) {
            if (Integer.parseInt(vNumber1[i]) > 0) {
                return 1;
            }
        }

        for (; i < vNumber2.length; i++) {
            if (Integer.parseInt(vNumber2[i]) > 0) {
                return -1;
            }
        }

        return 0;
    }
}
