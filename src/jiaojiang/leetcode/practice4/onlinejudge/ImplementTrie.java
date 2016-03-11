package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 9, 2016
 */
public class ImplementTrie {
    /*
     Implement a trie with insert, search, and startsWith methods.

    Note:
    You may assume that all inputs are consist of lowercase letters a-z.
     */

    class TrieNode {
        // Initialize your data structure here.
        char letter;
        TrieNode[] children;
        boolean isLeaf;
        
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isLeaf = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isLeaf;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
