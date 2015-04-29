package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 13, 2013 1:27:51 PM
 */
public class Discard {
    /*
    Given 14 cards, ranges from A to N. You have two ways to discard the card in below combinations:
    1.  2 - 4 of a kind, e.g., (B, B), (B, B, B) or (B, B, B, B)
    2.  3 straight cards

    Now please implement a function to return the minimal times that you can discard your card. Return -1 if can not.
    For example, "B C D D D D E F G H I", returns 5 since [B C D], [D D], [D E F], [G H I ]
    */

    //assume the input String is sorted and there is no A's in String s
    public static int discard(String s) {
        return discard(s, 0);
    }

    public static int discard(String s, int start) {
        if (start == s.length()) {
            return 0;
        }

        if (start == s.length() - 1) {
            return -1;
        }

        if (start == s.length() - 2) {
            if (s.charAt(start) == s.charAt(start + 1)) {
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
                    return increment(discard(s, index + 2));
                }
                return -1;
            }
            return -1;
        } else if (index == start + 2) {
            return increment(discard(s, index));
        }

        System.out.println("index : " + index + " start : " + start);
        //return min(discardNoAs(s, index - 1), discardNoAs(s, index)) + 1
        return min(discard(s, index - 1), discard(s, index)) + 1;
    }

    public static int discardDP(String s) {
        int[] ret = new int[s.length() + 1];
        ret[ret.length - 1] = 0;

        for (int i = 0; i < ret.length - 1; i++) {
            ret[i] = -1;
        }

        for (int i = s.length() - 1; i > 0; i--) {
            int j = i;
            while (j >= 0 && j > i - 4 && s.charAt(i) == s.charAt(j)) {
                j--;
            }

            if (j == i - 1) {
                if (i > 1 && s.charAt(i) - s.charAt(i - 1) == 1 && s.charAt(i - 1) - s.charAt(i - 2) == 1) {
                    ret[i - 2] = min(ret[i - 2], increment(ret[i + 1]));
                }
            } else if (j == i - 2) {
                ret[j + 1] = min(ret[j + 1], increment(ret[i + 1]));
            } else {
                ret[j + 1] = min(ret[j + 1], min(increment(ret[i + 1]), increment(ret[i])));
                ret[j + 2] = min(ret[j + 2], j == i - 4 ? ret[j + 1] : increment(ret[i + 1]));
            }
        }

        return ret[0];
    }

    private static int increment(int ret) {
        return ret == -1 ? -1 : ret + 1;
    }

    // i1, i2 are in the range [-1, Integer.MAX_VALUE]
    private static int min(int i1, int i2) {
        if (i1 <= i2) {
            if (i1 == -1) {
                return i2;
            }
            return i1;
        }
        return min(i2, i1);
    }

    public static void test() {
        Utils.printTestln(discard("bbbbcde"), 2);
        Utils.printTestln(discard("bcddddefghi"), 4);
        Utils.printTestln(discard("bcdddefghi"), -1);
        Utils.printTestln(discard("abcdddefgghi"), 4);
        Utils.printTestln(discard("abcdddefggghi"), 5);
        Utils.printTestln(discard("abcddddefgggghi"), 5);
        Utils.printTestln(discard("abceeeeefgggghi"), 5);

        System.out.println("=========== DP ===========");

        Utils.printTestln(discardDP("bbbbcde"), 2);
        Utils.printTestln(discardDP("bcddddefghi"), 4);
        Utils.printTestln(discardDP("bcdddefghi"), -1);
        Utils.printTestln(discardDP("abcdddefgghi"), 4);
        Utils.printTestln(discardDP("abcdddefggghi"), 5);
        Utils.printTestln(discardDP("abceeeeefgggghi"), 5);
    }

    public static void main(String[] args) {
        test();
    }
}
