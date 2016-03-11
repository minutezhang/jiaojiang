package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class MaximumProductOfWorldLength {
    /*
        Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not
        share common letters. You may assume that each word will contain only lower case letters. If no such two words
        exist, return 0.

        Example 1:

        Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
        Return 16
        The two words can be "abcw", "xtfn".

        Example 2:

        Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
        Return 4
        The two words can be "ab", "cd".

        Example 3:

        Given ["a", "aa", "aaa", "aaaa"]
        Return 0
        No such pair of words.
     */
    public static int maxProduct(String[] words) {
        int[] wordInts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordInts[i] = wordInts[i] | 1 << (c - 'a');
            }
        }

        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < wordInts.length; j++) {
                if ((wordInts[i] & wordInts[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }

        return maxProd;
    }
}
