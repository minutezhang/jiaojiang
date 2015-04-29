package companies.google.mitbbs;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @since: Oct 31, 2013 4:53:35 PM
 */
public class NGram {
    /*
    Given a string and a integer number N, output all the k-gram of the string with k <= N.
    For example, "hello world all" and 2, return "hello", "world", "all", "hello world", "world all"
     */
    public static List<String> getNGram(String words, int n) {
        int start[] = new int[n], end[] = new int[n], count = 0;
        List<String> ret = new ArrayList<String>();

        for (int i = 0; i <= words.length(); i++) {
            if (i == words.length() || words.charAt(i) == ' ') {
                if (start[count % n] == i || start[count % n] == i - 1) {
                    start[count % n] = i + 1;
                } else {
                    end[count % n] = i;
                    ret.add(words.substring(start[count % n], end[count % n]));

                    for (int j = 1; j <= Math.min(count, n - 1); j++) {
                        ret.add(words.substring(start[(count - j) %n], end[count % n]));
                    }

                    count++;
                    start[count % n] = i + 1;
                }
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printListln(getNGram("hello world all", 2));
        Utils.printListln(getNGram("hello world all huiqing max min rulan", 3));

        Utils.printListln(getNGram("  hello world all huiqing max min rulan", 3));
        Utils.printListln(getNGram("  hello world    all huiqing max min rulan", 3));
    }

    public static void main(String[] args) {
        test();
    }
}
