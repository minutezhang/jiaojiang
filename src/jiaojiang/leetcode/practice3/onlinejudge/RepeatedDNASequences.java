package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mizhang
 * @time: 2/12/15 3:16 PM
 */
public class RepeatedDNASequences {
    /*
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
    studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    For example,

    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

    Return:
    ["AAAAACCCCC", "CCCCCAAAAA"].
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            if (!counts.containsKey(sequence)) {
                counts.put(sequence, 1);
            } else if (counts.get(sequence) == 1) {
                ret.add(sequence);
                counts.put(sequence, 2);
            }
        }

        return ret;
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> ret = new ArrayList<String>();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i = 0; i < s.length() - 9; i++) {
            int intSequence = sequenceToInt(s, i);
            String sequence = s.substring(i, i + 10);
            if (!counts.containsKey(intSequence)) {
                counts.put(intSequence, 1);
            } else if (counts.get(intSequence) == 1) {
                ret.add(sequence);
                counts.put(intSequence, 2);
            }
        }

        return ret;
    }

    private static int sequenceToInt(String s, int start) {
        int ret = 0;
        for (int i = 0; i < 10; i++) {
            ret = (ret << 2) + getNumber(s.charAt(start + i));
        }
        return ret;
    }

    private static int getNumber(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        throw new IllegalArgumentException("Wrong argument: " + c);
    }
}
