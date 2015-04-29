package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 2:38:48 PM
 */
public class LongestCommonPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer ret = new StringBuffer();

        if (strs.length == 0) {
            return ret.toString();
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return ret.toString();
                }
            }
            ret.append(c);
        }
        return ret.toString();
    }

    public static void test() {
        String[] strs = new String[]{
                "abc", "aborginal", "abnormal"
        };
        System.out.println(longestCommonPrefix(strs));

        strs = new String[]{""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static void main(String[] args) {
        test();
    }
}
