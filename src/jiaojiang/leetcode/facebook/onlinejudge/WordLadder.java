package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Aug 31, 2016
 */
public class WordLadder {
    /*
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
    sequence from beginWord to endWord, such that:

        Only one letter can be changed at a time
        Each intermediate word must exist in the word list

    For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:

        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
     */
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        int depth = 2;

        while (!queue.isEmpty()) {
            Set<String> visited = new HashSet<String>();
            String word = queue.remove();
            if (word == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    depth++;
                }
            } else {
                if (isNeighbor(word, endWord)) {
                    return depth;
                }
                for (String w : wordList) {
                    if (isNeighbor(word, w)) {
                        visited.add(w);
                        queue.add(w);
                    }
                }
                wordList.removeAll(visited);
            }
        }

        return 0;
    }

    public static int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        int depth = 2;

        while (!queue.isEmpty()) {
            Set<String> visited = new HashSet<String>();
            String word = queue.remove();
            if (word == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    depth++;
                }
            } else {
                if (isNeighbor(word, endWord)) {
                    return depth;
                }
                for (String w : getNeighbors(word, wordList)) {
                    visited.add(w);
                    queue.add(w);
                }
                wordList.removeAll(visited);
            }
        }

        return 0;
    }

    private static boolean isNeighbor(String word, String word2) {
        int distance = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word2.charAt(i)) {
                distance++;
                if (distance > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Set<String> getNeighbors(String word, Set<String> dict) {
        Set<String> neighbors = new HashSet<String>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (currentChar != c) {
                    charArray[i] = c;
                    String neighbor = new String(charArray);
                    if (dict.contains(neighbor)) {
                        neighbors.add(neighbor);
                        dict.remove(neighbor);
                    }
                }
            }
            charArray[i] = currentChar;
        }

        return neighbors;
    }
}
