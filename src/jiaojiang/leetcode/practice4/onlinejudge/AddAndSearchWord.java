package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Jun 23, 2016
 */
public class AddAndSearchWord {
    /*
    Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)

    search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

    For example:

    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad") -> false
    search("bad") -> true
    search(".ad") -> true
    search("b..") -> true
     */

    private class Node {
        private Node[] childNodes;

        private Node() {
            childNodes = new Node[27];
        }
    }

    private Node prefixTree = new Node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node node = prefixTree;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.childNodes[c - 'a'] == null) {
                node.childNodes[c - 'a'] = new Node();
            }
            node = node.childNodes[c - 'a'];
        }
        node.childNodes[26] = new Node();
    }

    public boolean search(String word) {
        return search(prefixTree, word, 0);
    }

    private static boolean search(Node node, String word, int startIndex) {
        if (node == null) {
            return false;
        }
        if (word.length() == startIndex) {
            return node.childNodes[26] != null;
        }

        char c = word.charAt(startIndex);
        if (c == '.') {
            for (Node childNode: node.childNodes) {
                if (search(childNode, word, startIndex + 1)) {
                    return true;
                }
            }
            return false;
        }

        return search(node.childNodes[c - 'a'], word, startIndex + 1);
    }
}
