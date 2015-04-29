package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 2:02:59 PM
 */
public class CountAndSay {
    /*
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n, generate the nth sequence.

    Note: The sequence of integers will be represented as a string.
    */

    public static String countAndSay(int n) {
        String pre = "1";

        for (int i = 1; i < n; i++) {
            pre = countAndSay(pre);
        }

        return pre;
    }

    private static String countAndSay(String pre) {
        int i = 0, n = pre.length();

        StringBuffer ret = new StringBuffer();

        while (i < n) {
            char c = pre.charAt(i);
            int count = 1;
            while (++i < n && pre.charAt(i) == c) {
                count++;
            }

            // the value of count is not greater than 3
            ret.append((char)(count + '0'));
            ret.append(c);
        }

        return ret.toString();
    }

    public static void test() {
        System.out.println(countAndSay(1));   // 1
        System.out.println(countAndSay(2));   // 11
        System.out.println(countAndSay(3));   // 21
        System.out.println(countAndSay(4));   // 1211
        System.out.println(countAndSay(5));   // 111221
        System.out.println(countAndSay(6));   // 312211
        System.out.println(countAndSay(7));   // 13112221
        System.out.println(countAndSay(8));   // 1113213211
        System.out.println(countAndSay(9));   // 31131211131221

    }

    public static void main(String[] args) {
        test();
    }
}
