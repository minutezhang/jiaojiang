package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class GroupAnagrams {
    /*
    Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(str);
        }

        List<List<String>> ret = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ret.add(entry.getValue());
        }

        return ret;
    }
}
