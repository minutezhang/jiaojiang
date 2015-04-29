package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: Apr 30, 2013 9:19:45 PM
 */
public class Anagrams {
    /*
    Given an array of strings, return all groups of strings that are anagrams.

    Note: All inputs will be in lower-case.
     */
    public static ArrayList<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);
            }
        }

        ArrayList<String> ret = new ArrayList<String>();

        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                ret.addAll(map.get(s));
            }
        }
        return ret;
    }

    public static void test() {
        for (String s : anagrams(new String[]{"ape","pea","tax"})) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
