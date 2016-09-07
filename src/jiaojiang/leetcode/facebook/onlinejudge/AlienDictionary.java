package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Sep 4, 2016
 */
public class AlienDictionary {
    /*
    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
    You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new
    language. Derive the order of letters in this language.
    For example,
    Given the following words in dictionary,

    [
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    ]

    The correct order is: "wertf".
    Note:

        You may assume all letters are in lowercase.
        If the order is invalid, return an empty string.
        There may be multiple valid order of letters, return any one of them is fine.
     */
    public static String alienOrder(String[] words) {
        // w e r
        // r t
        // t f
        int[] inDegrees = new int[256];
        Map<Character, List<Character>> adjacencies = new HashMap<Character, List<Character>>();

        for (int i = 0; i < words.length - 1; i++) {
            int j, minLength = Math.min(words[i].length(), words[i + 1].length());
            for (j = 0;
                 j < minLength && words[i].charAt(j) == words[i + 1].charAt(j);
                 j++);
            if (j < minLength) {
                inDegrees[words[i + 1].charAt(j)]++;
                List<Character> adjacency = adjacencies.get(words[i].charAt(j));
                if (adjacency == null) {
                    adjacency = new ArrayList<Character>();
                    adjacencies.put(words[i].charAt(j), adjacency);
                }
                adjacency.add(words[i + 1].charAt(j));
            }
        }

        return topologicalSort(inDegrees, adjacencies);
    }

    private static String topologicalSort(int[] inDegrees, Map<Character, List<Character>> adjacencies) {
        StringBuilder ret = new StringBuilder();
        Set<Character> alpha = adjacencies.keySet();
        Queue<Character> queue = new LinkedList<Character>();
        for (Character c : alpha) {
            if (inDegrees[c] == 0) {
                queue.add(c);
            }
        }

        if (queue.size() != 1) {
            return "";
        }

        while (!queue.isEmpty()) {
            char c = queue.remove();
            ret.append(c);
            List<Character> adjacencyList = adjacencies.get(c);
            if (adjacencyList != null) {
                for (char adj : adjacencyList) {
                    inDegrees[adj]--;
                    if (inDegrees[adj] == 0) {
                        queue.add(adj);
                    }
                }
                alpha.remove(c);
            }
        }

        return alpha.isEmpty() ? ret.toString() : "";
    }
}
