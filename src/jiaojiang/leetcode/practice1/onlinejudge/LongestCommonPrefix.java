package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 12, 2013 11:51:42 PM
 */
public class LongestCommonPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings
     */
     public static String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) {
             return "";
         }
         StringBuffer ret = new StringBuffer();

         for (int i = 0, n = strs[0].length(); i < n; i++) {
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

    public static void testLCP() {
        String[] strs1 = {"a","b"};
        String desired1 = "";
        String[] strs2 = {"aaa","aa","aaa"};
        String desired2 = "aa";
        String[] strs3 = {"abc","abcc","abc","abca","abca"};
        String desired3 = "abc";

        System.out.println(longestCommonPrefix(strs1) + " : " + desired1);
        System.out.println(longestCommonPrefix(strs2) + " : " + desired2);
        System.out.println(longestCommonPrefix(strs3) + " : " + desired3);
    }

    public static void main(String[] args) {
         testLCP();

    }
}
