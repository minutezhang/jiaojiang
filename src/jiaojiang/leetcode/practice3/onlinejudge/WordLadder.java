package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.*;

/**
 * @author: mizhang
 * @time: 3/2/15 11:20 AM
 */
public class WordLadder {
    /*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        Queue<String>[] q = new Queue[2];
        q[0] = new LinkedList<String>();
        q[1] = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        List<String> neighbors = new ArrayList<String>();

        dict.add(end);
        q[0].add(start);

        for (int length = 0; !q[0].isEmpty() || !q[1].isEmpty(); length++) {
            while (!q[length & 1].isEmpty()) {
                String word = q[length & 1].remove();
                if (word.equals(end)) {
                    return length + 1;
                }
                visited.add(word);
                getNeighbors(word, dict, visited, neighbors);
                q[(length + 1) & 1].addAll(neighbors);
            }
        }

        return 0;
//        dict.add(start);
//        dict.add(end);
//
//        return ladderLength(1, start, end, dict, new HashSet<String>());
    }

    private static void getNeighbors(String s, Set<String> dict, Set<String> visited, List<String> neighbors) {
        neighbors.clear();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (char nc = 'a'; nc <= 'z'; nc++) {
                if (nc != c) {
                    chars[i] = nc;
                    String ns = new String(chars);
                    if (dict.contains(ns) && !visited.contains(ns)) {
                        neighbors.add(ns);
                    }
                }
                chars[i] = c;
            }
        }
    }


    public static int ladderLength2(String start, String end, Set<String> dict) {
        Queue<String>[] q = new Queue[2];
        q[0] = new LinkedList<String>();
        q[1] = new LinkedList<String>();
        List<String> neighbors = new ArrayList<String>();

        dict.add(end);
        q[0].add(start);

        for (int length = 0; !q[0].isEmpty() || !q[1].isEmpty(); length++) {
            while (!q[length & 1].isEmpty()) {
                String word = q[length & 1].remove();
                if (word.equals(end)) {
                    return length + 1;
                }
                dict.remove(word);
                getNeighbors2(word, dict, neighbors);
                q[(length + 1) & 1].addAll(neighbors);
            }
        }

        return 0;
    }

    private static void getNeighbors2(String s, Set<String> dict, List<String> neighbors) {
        neighbors.clear();

        for (String d : dict) {
            if (isNeighbor(s, d)) {
                neighbors.add(d);
            }
        }

        dict.removeAll(neighbors);
    }

    private static boolean isNeighbor(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            count += w1.charAt(i) == w2.charAt(i) ? 0 : 1;
            if (count > 1) {
                return false;
            }
        }

        return true;
    }



    // DFS is not correct
    private static int ladderLength(int length, String start, String end, Set<String> dict, Set<String> visited) {
        if (start.equals(end)) {
            return length;
        }

        if (visited.contains(start)) {
            return 0;
        }

        visited.add(start);

        List<String> neighbors = getNeighbors(start, dict, visited);

        for (String n : neighbors) {
            int l;
            if ((l = ladderLength(length + 1, n, end, dict, visited)) != 0) {
                return l;
            }
        }

        return 0;
    }

    private static List<String> getNeighbors(String s, Set<String> dict, Set<String> visited) {
        List<String> neighbors = new ArrayList<String>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (char nc = 'a'; nc <= 'z'; nc++) {
                if (nc != c) {
                    chars[i] = nc;
                    String ns = new String(chars);
                    if (dict.contains(ns) && ! visited.contains(ns)) {
                        neighbors.add(ns);
                    }
                }
                chars[i] = c;
            }
        }

        return neighbors;
    }
}
