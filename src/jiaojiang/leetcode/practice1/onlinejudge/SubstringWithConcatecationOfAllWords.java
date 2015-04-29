package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 14, 2013 9:33:21 PM
 */
public class SubstringWithConcatecationOfAllWords {
    /*
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices
    of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

     For example, given:
     S: "barfoothefoobarman"
     L: ["foo", "bar"]

     You should return the indices: [0,9].
    (order does not matter).
     */
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Map<String, Integer> wordCounter = new HashMap<String, Integer>();

        int l = L[0].length();

        for (String s : L) {
            if (wordCounter.containsKey(s)) {
                wordCounter.put(s, wordCounter.get(s) + 1);
            } else {
                wordCounter.put(s, 1);
            }
        }

        for (int i = 0, n = S.length(); i < n - L.length * l + 1; i++) {
            Map<String, Integer> tmp = new HashMap<String, Integer>(wordCounter);
            int count = L.length, j = i;
            String w;
            while (count > 0 && tmp.containsKey(w = S.substring(j, j + l)) && tmp.get(w) != 0) {
                tmp.put(w, tmp.get(w) - 1);
                j += l;
                count--;
            }
            if (count == 0) {
                ret.add(i);
            }
        }

        return ret;
    }

    public static void test() {
        Utils.printTestListln(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}), Arrays.asList(0, 9));
    }

    public static void main(String[] args) {
        test();
    }
}
