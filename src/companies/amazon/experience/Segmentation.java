package companies.amazon.experience;


import java.util.HashSet;
import java.util.Set;

/**
 * @author: mizhang
 * @version: 6/11/13 10:00 AM
 */
public class Segmentation {

    public static String segment(String s, Set<String> dict) {
        return segment(s, 0, dict);
    }

    public static String segment(String s, int start, Set<String> dict) {
        int st = start, end = start + 1, n = s.length();

        if (st == n) {
            return "";
        }

        String w = null, w2 = null;
        while (end <= n && (!dict.contains(w = s.substring(st, end)) || (w2 = segment(s, end, dict)) == null)) {
            end++;
        }

        if (end == n + 1) {
            return null;
        }

        return "".equals(w2) ?  w : w + " " + w2;
    }

    public static void test() {
        Set<String> dict = new HashSet<String>();
        dict.add("amazon");
        dict.add("amazonian");
//        dict.add("kidding");
        dict.add("kid");
        dict.add("din");
        dict.add("ding");
        System.out.println(segment("amazoniankidding", dict));
        System.out.println(segment("amazonkid", dict));
    }

    public static void main(String[] args) {
        test();

    }
}