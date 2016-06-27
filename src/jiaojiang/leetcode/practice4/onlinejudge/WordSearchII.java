package jiaojiang.leetcode.practice4.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Jun 26, 2016
 */
public class WordSearchII {
    /*
     Given a 2D board and a list of words from the dictionary, find all words in the board.

    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

    For example,
    Given words = ["oath","pea","eat","rain"] and board =

    [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]

    Return ["eat","oath"].
     */
    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<String>();
        for (String word : words) {
            if (wordSearch(board, word)) {
                ret.add(word);
            }
        }
        return new ArrayList<String>(ret);
    }

    private static boolean wordSearch(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordSearch(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordSearch(char[][] board, boolean[][] visited, int i, int j, String word, int start) {
        if (word.length() == start) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(start) != board[i][j]) {
            return false;
        }

        try {
            visited[i][j] = true;
            return wordSearch(board, visited, i - 1, j, word, start + 1) || wordSearch(board,  visited, i + 1, j, word, start + 1)
                    || wordSearch(board, visited, i, j + 1, word, start + 1) || wordSearch(board, visited, i, j - 1, word, start + 1);
        } finally {
            visited[i][j] = false;
        }
    }

    private static class TrieNode {
        private TrieNode[] childNodes = new TrieNode[27];

        public void addWord(String word) {
            addWord(word, 0);
        }

        private void addWord(String word, int start) {
            if (word.length() == start) {
                childNodes[26] = new TrieNode();
                return;
            }

            int index = word.charAt(start) - 'a';
            if (childNodes[index] == null) {
                childNodes[index] = new TrieNode();
            }

            childNodes[index].addWord(word, start + 1);
        }
    }

    public static List<String> findWordsTrie(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWordsTrie(board, new boolean[board.length][board[0].length], i, j, root, new StringBuilder(), ret);
            }
        }

        Collections.sort(ret);
        return ret;
    }

    public static void findWordsTrie(char[][] board, boolean[][] visited, int i, int j, TrieNode node, StringBuilder prefix, List<String> ret) {
        if (node.childNodes[26] != null) {
            ret.add(prefix.toString());
            node.childNodes[26] = null;
        }

        if (i >= 0 &&  i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && node.childNodes[board[i][j] - 'a'] != null) {
            prefix.append(board[i][j]);
            visited[i][j] = true;
            findWordsTrie(board, visited, i - 1, j, node.childNodes[board[i][j] - 'a'], prefix, ret);
            findWordsTrie(board, visited, i + 1, j, node.childNodes[board[i][j] - 'a'], prefix, ret);
            findWordsTrie(board, visited, i, j - 1, node.childNodes[board[i][j] - 'a'], prefix, ret);
            findWordsTrie(board, visited, i, j + 1, node.childNodes[board[i][j] - 'a'], prefix, ret);
            prefix.setLength(prefix.length() - 1);
            visited[i][j] = false;
        }
    }
}
