package companies.facebook.mitbbs;

import java.util.Set;
import java.util.HashSet;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 5:20:42 PM
 */
public class MaxWordSegmentation {
    /*
    Word breaking
    // How many spaces can we add to a word such that:
    // All subwords can be found within a given dictionary

    // fireman

    // fire man -> 2 words
    // fir em an -> 3 words

    /* DICT
    a
    an
    em
    fir
    fire
    ire
    ma
    man
    */
    public static int maxWordSegment(String s, Set<String> dict) {
        return maxWordSegment(s, 0, dict);
    }

    private static int maxWordSegment(String s, int start, Set<String> dict) {
        int l = s.length(), nWords = -1;

        if (start == l) {
            return 0;
        }

        for (int i = start; i < l; i++) {
            int n;
            if (dict.contains(s.substring(start, i + 1)) && (n = maxWordSegment(s, i + 1, dict)) != -1) {
                nWords = Math.max(nWords, n + 1);
            }
        }

        return nWords;
    }

    public static int maxWordSegmentMem(String s, Set<String> dict) {
        int[] mem = new int[s.length() + 1];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }

        return maxWordSegmentMem(s, dict, 0, mem);
    }

    private static int maxWordSegmentMem(String s, Set<String> dict, int start, int[] mem) {
        int l = s.length();

        if (start == l) {
            return mem[start] = 0;
        }

        if (mem[start] != -1) {
            System.out.println("::::using mem value");
            return mem[start];
        }

        for (int i = start; i < l; i++) {
            int n;
            if (dict.contains(s.substring(start, i + 1)) && (n = maxWordSegmentMem(s, dict, i + 1, mem)) != -1) {
                mem[start] = Math.max(mem[start], n + 1);
            }
        }

        return mem[start];
    }

    public static int maxWordSegmentDP(String s, Set<String> dict) {
        int n = s.length(), index = n - 1;
        int[] number = new int[n + 1];
        number[n] = 1;

        while (!dict.contains(s.substring(index, n))) {
            index--;
        }
        number[index--] = 2;

        for (int i = index; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (number[j] != 0 && dict.contains(s.substring(i, j))) {
                    number[i] = Math.max(number[i], number[j] + 1);
                }
            }
        }

        return number[0] - 1;
    }

    public static void test() {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("an");
        dict.add("em");
        dict.add("fir");
        dict.add("fire");
        dict.add("ire");
        dict.add("ma");
        dict.add("man");

        System.out.println(maxWordSegment("fireman", dict));  //3
        System.out.println(maxWordSegmentMem("fireman", dict));  //3
        System.out.println(maxWordSegmentDP("fireman", dict));  //3

        dict.clear();
        dict.add("hell");
        dict.add("hello");
        dict.add("ow");
        dict.add("oworld");
        dict.add("wor");
        dict.add("ld");

        System.out.println(maxWordSegment("helloworld", dict)); //3
        System.out.println(maxWordSegmentMem("helloworld", dict)); //3
        System.out.println(maxWordSegmentDP("helloworld", dict)); //3
    }

    public static void main(String[] args) {
        test();
    }
}