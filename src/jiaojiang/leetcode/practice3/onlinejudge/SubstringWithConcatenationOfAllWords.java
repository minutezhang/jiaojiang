package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Mar 5, 2015 9:34:05 PM
 */
public class SubstringWithConcatenationOfAllWords {
    /*
     You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of
     substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).
     */
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        int wordLength = L[0].length();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String s : L) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }

        for (int i = 0; i < S.length() - L.length * wordLength + 1; i++) {
            if (counts.containsKey(S.substring(i, i + wordLength))) {
                Map<String, Integer> tmpCounts = new HashMap<String, Integer>(counts);
                int j;
                for (j = 0; j < L.length; j++) {
                    String s = S.substring(i + j * wordLength, i + (j + 1) * wordLength);
                    if (!tmpCounts.containsKey(s) ||  tmpCounts.get(s) == 0) {
                        break;
                    }
                    tmpCounts.put(s, tmpCounts.get(s) - 1);
                }
                if (j == L.length) {
                    ret.add(i);
                }
            }
        }

        return ret;
    }
}
