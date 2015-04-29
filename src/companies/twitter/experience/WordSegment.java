package companies.twitter.experience;

import java.util.*;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 4:32:23 PM
 */
public class WordSegment {
    /*
    Given a dictionary and a String without space, find a good segment for this String. A good segment means the String
    could be break into words without any leftover.
    For example,
    dictionary: {"amazonian", "happy", "amazon", "amazing", "amaze"}
    String s : amazonianhappy
    will break into "amazonian" and "happy"
     */
    public static List<String> segment(String s, Set<String> dict) {
        return segment(s, 0, dict);
    }

    private static LinkedList<String> segment(String s, int start, Set<String> dict) {
        if (start == s.length()) {
            return new LinkedList<String>();
        }

        for (int i = start, n = s.length(); i < n; i++) {
            LinkedList<String> words;
            if (dict.contains(s.substring(start, i + 1)) && (words = segment(s, i + 1, dict)) != null) {
                words.addFirst(s.substring(start, i + 1));
                return words;
            }
        }

        return null;
    }

    public static void test(String s, Set<String> dict) {
        List<String> ret = segment(s, dict);
        if (ret == null) {
            System.out.println("======no segmentation found======");
            return;
        }

        for (String str : ret) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void test() {
        Set<String> dict = new HashSet<String>();
        dict.add("amazonian");
        dict.add("happy");
        dict.add("amazon");
        dict.add("amazing");
        dict.add("amaze");
        dict.add("happily");
        dict.add("buyer");

        test("amazonianhappy", dict);
        test("amazonianbuyer", dict);
        test("amazoniahappy", dict);
    }

    public static void main(String[] args) {
        test();
    }

}