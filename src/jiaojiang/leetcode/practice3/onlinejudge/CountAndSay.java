package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/10/15 10:21 PM
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
        String ret = "1";
        StringBuffer say = new StringBuffer();

        for (int i = 2; i <= n; i++) {
            say.setLength(0);
            char c = ret.charAt(0);
            int count = 1;
            for (int j = 1; j < ret.length(); j++) {
                if (ret.charAt(j) == c) {
                    count++;
                } else {
                    say.append((char)(count + '0')).append(c);
                    count = 1;
                    c = ret.charAt(j);
                }
            }
            say.append((char)(count + '0')).append(c);
            ret = say.toString();
        }

        return ret;
    }
}