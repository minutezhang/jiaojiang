package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 13, 2013 3:16:24 PM
 */
public class DiscardII {
    /*
    Given 14 cards, ranges from A to N. You have two ways to discard the card in below combinations:
    1.  2 - 4 of a kind, e.g., (B, B), (B, B, B) or (B, B, B, B)
    2.  3 straight cards
    By the way, A can be used as any card

    Now please implement a function to return the minimal times that you can discard your card. Return -1 if can not.
    For example, "A B C D D D D E F G H I J N", returns 5 since [B C D], [D D D], [E F G], [H I J], [A N]
    */

    //assume the input String is sorted and there is no A's in String s
    public static int discard(String s, int numberOfAs) {




        return -1;
    }

    public static int discardNoAs(String s, int start) {
        if (start == s.length()) {
            return 0;
        }

        if (start == s.length() - 1) {
            return -1;
        }

        char c1 = s.charAt(start);
        char c2 = s.charAt(start + 1);

        if (start == s.length() - 2) {
            if (c1 == c2) {
                return 1;
            }
            return -1;
        }

        int index = start;
        while (index < s.length() && index < start + 4 && s.charAt(start) == s.charAt(index)) {
            index++;
        }

        if (index == start + 1) {
            if (s.charAt(index) - s.charAt(start) == 1) {
                if (s.charAt(index + 1) - s.charAt(index) == 1) {
                    int n = discardNoAs(s, index + 2);
                    return n == -1 ? -1 : n + 1;
                }
                return -1;
            }
        } else if (index == start + 2) {
            int n = discardNoAs(s, index);
            return n == -1 ? -1 : n + 1;
        }

        //return min(discardNoAs(s, index - 1), discardNoAs(s, index)) + 1
        int n = discardNoAs(s, index - 1), m = discardNoAs(s, index);
        if (n == -1 && m == -1) {
            return -1;
        }
        if (n == -1) {
            return m + 1;
        }
        if (m == -1) {
            return n + 1;
        }

        return Math.min(m, n) + 1;
    }

    public static void test() {
//        Utils.printTestln(discard("abcddddefghijn".toUpperCase()), 5);
        Utils.printTestln(discardNoAs("bbbbcde", 0), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
