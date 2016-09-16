package jiaojiang.leetcode.uber.onlinejudge;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 14, 2016
 */
public class GroupShiftedStrings {
    /*
    Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We
    can keep "shifting" which forms the sequence:

    "abc" -> "bcd" -> ... -> "xyz"

    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same
    shifting sequence.
    For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
    Return:

    [
      ["abc","bcd","xyz"],
      ["az","ba"],
      ["acef"],
      ["a","z"]
    ]

    Note: For the return value, each inner list's elements must follow the lexicographic order.
     */
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            char[] string = s.toCharArray();
            for (int i = string.length - 1; i >= 0; i--) {
                string[i] = (char)(((string[i] + 26 - 'a') - (string[0] - 'a')) %26 + 'a');
            }

            String canonicalString = new String(string);
            List<String> list = map.get(canonicalString);
            if (list == null) {
                list = new ArrayList<String>();
                map.put(canonicalString, list);
            }
            list.add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
