package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:22:26 PM
 */
public class PalindromePartition {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
    */
    public static ArrayList<ArrayList<String>> partition(String s) {
        return partition(s, s.length() - 1);
    }

    public static ArrayList<ArrayList<String>> partition(String s, int start) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (start == -1) {
            ret.add(new ArrayList<String>());
            return ret;
        }

        for (int i = start; i >= 0; i--) {
            ArrayList<ArrayList<String>> tmp;
            if (isPalindrome(s, i, start) && !(tmp = partition(s, i - 1)).isEmpty()) {
                for (ArrayList<String> l : tmp) {
                    l.add(s.substring(i, start + 1));
                    ret.add(l);
                }
            }
        }

        return ret;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    public static void test(String s) {
        for (ArrayList<String> l : partition(s)) {
            for (String str : l) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }

    public static void test() {
        test("aab");
    }

    public static void main(String[] args) {
        test();
    }
}
