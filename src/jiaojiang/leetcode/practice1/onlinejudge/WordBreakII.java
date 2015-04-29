package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author: mizhang
 * @since: Oct 28, 2013 10:52:01 AM
 */
public class WordBreakII {
    /*
     Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
     */
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        return wordBreak(s, 0, dict);
    }

    public static ArrayList<String> wordBreak(String s, int start, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();

        if (start == s.length()) {
            ret.add("");
            return ret;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            ArrayList<String> tmp;
            String word = s.substring(start, i);
            if (dict.contains(word) && (tmp = wordBreak(s, i, dict)) != null) {
                for (String words : tmp) {
                    ret.add(word + " " + words.trim());
                }
            }
        }

        return ret.isEmpty() ? null : ret;
    }

    public static ArrayList<String> wordBreakDP(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        Map<Integer, List<Integer>> nextIndices = new HashMap<Integer, List<Integer>>();
        dp[s.length()] = true;
        nextIndices.put(s.length(), new ArrayList<Integer>());

        for (int i = s.length(); i > 0; i--) {
            if (dp[i]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dict.contains(s.substring(j, i))) {
                        dp[j] = true;
                        if (!nextIndices.containsKey(j)) {
                            nextIndices.put(j, new ArrayList<Integer>());
                        }
                        nextIndices.get(j).add(i);
                    }
                }
            }
        }

        ArrayList<String> ret = new ArrayList<String>();
        wordBreakDPDFS(s, 0, nextIndices, new ArrayList<String>(), ret);

        return ret;
    }

    private static void wordBreakDPDFS(String s, int currentIndex, Map<Integer, List<Integer>> nextIndices, List<String> words, List<String> output) {
        if (!nextIndices.containsKey(currentIndex)) {
            return;
        }

        if (currentIndex == s.length()) {
            StringBuffer sb = new StringBuffer();
            for (String w : words) {
                sb.append(w).append(' ');
            }
            sb.setLength(sb.length() - 1);
            output.add(sb.toString());
        }


        for (int nextIndex : nextIndices.get(currentIndex)) {
            words.add(s.substring(currentIndex, nextIndex));
            wordBreakDPDFS(s, nextIndex,  nextIndices,  words, output);
            words.remove(words.size() - 1);
        }
    }

    public static void test() {
        Utils.printListln(wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

        System.out.println("------------------");

        Utils.printListln(wordBreakDP("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
        Utils.printListln(wordBreakDP("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }

    public static void main(String[] args) {
        test();
    }
}
