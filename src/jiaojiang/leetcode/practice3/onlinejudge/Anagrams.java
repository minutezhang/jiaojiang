package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

import java.util.*;

/**
 * @author: mizhang
 * @since: Dec 12, 2014 4:33:08 PM
 */
public class Anagrams {
    /*
    Given an array of strings, return all groups of strings that are anagrams.

    Note: All inputs will be in lower-case.
     */
    public static List<String> anagrams(String[] strs) {
        Map<String, String> anagrams = new HashMap<String, String>();
        List<String> ret = new ArrayList<String>();

        for (String s : strs) {
            String key = orderedString(s);
            if (anagrams.containsKey(key)) {
                if (anagrams.get(key) == null) {
                    ret.add(s);
                } else {
                    ret.add(anagrams.get(key));
                    ret.add(s);
                    anagrams.put(key, null);
                }
            } else {
                anagrams.put(key, s);
            }
        }

        return ret;
    }

    private static String orderedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void test() {
        Test.printStringList(anagrams(new String[]{"ape", "pea", "tax"}));
    }

    public static void main(String[] args) {
        test();
    }

}
