package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: Oct 26, 2013 11:06:11 PM
 */
public class WordBreak {
    /*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, 0, dict);
    }

    public static boolean wordBreak(String s, int start, Set<String> dict) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(start, i)) && wordBreak(s, i, dict)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreakDP(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;

        int index = s.length() - 1;
        while (index >= 0 && !dict.contains(s.substring(index))) {
            index--;
        }

        if (index < 0) {
            return false;
        }

        dp[index--] = true;
        while (index >= 0) {
            int i = dp.length - 1;
            for (; i > index && (!dp[i] || !dict.contains(s.substring(index, i))); i--);
            dp[index] = i != index--;
//            for (int i = dp.length - 1; i > index; i--) {
//                if (dp[i] && dict.contains(s.substring(index, i))){
//                    dp[index] = true;
//                    break;
//                }
//            }
//            index--;
        }

        return dp[0];
    }

    public static void test() {
        Utils.printTestln(wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(wordBreak("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);

        System.out.println("------------------");
        
        Utils.printTestln(wordBreakDP("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(wordBreakDP("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(wordBreakDP("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);
        Utils.printTestln(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))), false);
    }

    public static void main(String[] args) {
        test();
    }
}
