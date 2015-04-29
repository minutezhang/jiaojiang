package companies.facebook.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 11, 2014 11:57:33 PM
 */
public class OneEdit {
    /*
    check whether one word can be transformed to another only by one edit distance:

    An eidt allows below 3 operations on a word:
    a) Insert a character
    b) Delete a character
    c) Replace a character

    Your program only allows to scan the string once.
    */

    // insert equals delete on the other word. Assum word w1 is always shorter than w2 and we can only consider delete on
    //word w2 and no insert is involved
    public static boolean oneEdit(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if (l1 > l2) {
            String tmp = word2;
            word2 = word1;
            word1 = tmp;
            l1 ^= l2;
            l2 ^= l1;
            l1 ^= l2;
        }

        if (l2 - l1 > 1) {
            return false;
        }

        boolean replaceOnly = l2 == l1;
        int s1, s2;
        
        for (s1 = 0, s2 = 0; s1 < l1 && s2 < l2 && word1.charAt(s1) == word2.charAt(s2); s1++, s2++);

        s2++;
        if (replaceOnly) {
            s1++;
        }

        for (; s1 < l1 && s2 < l2 && word1.charAt(s1) == word2.charAt(s2); s1++, s2++);

        return s1 == l1 && s2 == l2;
    }

    private static void test() {
        Utils.printTestln(oneEdit("one", "on"), true);
        Utils.printTestln(oneEdit("tone", "tony"), true);
        Utils.printTestln(oneEdit("one", "two"), false);
        Utils.printTestln(oneEdit("one", "tone"), true);
        Utils.printTestln(oneEdit("o", ""), true);
        Utils.printTestln(oneEdit("max", "min"), false);
    }

    public static void main(String[] args) {
        test();
    }
    
}
