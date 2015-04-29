package companies.google.mitbbs;

import java.util.Arrays;

/**
 * @author: mizhang
 * @since: Nov 22, 2013 1:10:02 PM
 */
public class CodeLock {
    /*
     A digital door lock with a 4-digit code and therefore there are totally 10000 combinations. Need to find a shorted
     string that all these 10000 combinations are exists in the string.

     For example. assume you have a 2-digit code and each digit ranges from 0 to 1, then you have 4 different combinations:
     00, 01, 10, 11 and 0011 contains all the combinations (from last to first is 10)

     It is also called De Bruijn sequence.

     NOTE: actually, the solution does exist as De Bruijn sequece. If you do not know De Bruijn sequence solution exist,
     you should try assign weight to each edge, e.g. 0000 --> 0001, weight is 1 and 0000 --> 0111 weight is 3 and
     edge between 0000 --> 1111 weight is 4
     */
    public static String getSequence() {
        StringBuffer s = new StringBuffer("00");
        boolean[] hasVisited = new boolean[100];
        hasVisited[0] = true;

        for (int n : getNeighbors(0)) {
            if (n != 0 && getHamiltonianCycle(n, s, hasVisited, 2)) {
                return s.toString();
            }
        }

        return "";
    }

    private static boolean getHamiltonianCycle(int i, StringBuffer s, boolean[] hasVisited, int count) {
        hasVisited[i] = true;
        s.append(i % 10);

        if (count == 99) {
            return !hasVisited[Integer.parseInt(s.substring(99) + s.substring(0, 1))];
        }

        for (int n : getNeighbors(i)) {
            if (!hasVisited[n] && n != i) {
                if (getHamiltonianCycle(n, s, hasVisited, count + 1)) {
                    return true;
                }
                hasVisited[n] = false;
                s.setLength(s.length() - 1);
            }
        }

        return false;
    }


    public static String getSequence2() {
        StringBuffer s = new StringBuffer();
        if (getHamiltonianCycle2(0, s, new boolean[100], 0) == 0) {
            return s.toString();
        }

        return "";
    }

    // work version but looks ugly
    public static int getHamiltonianCycle2(int i, StringBuffer s, boolean[] hasVisited, int count) {
        if (count == 99) {
            if (!hasVisited[Integer.parseInt(s.substring(99) + s.substring(0, 1))]) {
                return 0;
            }
            return 1;
        }

        if (hasVisited[i]) {
            return 2;
        }

        hasVisited[i] = true;
        if (count == 0) {
            s.append(String.format("%02d", i));
        } else {
            s.append(i%10);
        }

        for (int neighbor : getNeighbors(i)) {
            if (i == neighbor) {
                continue;
            }
            int retCode = getHamiltonianCycle2(neighbor, s, hasVisited, count + 1);
            if (retCode == 0) {
                return 0;
            }

            if (retCode == 1) {
                return 3;
            }

            if (retCode == 3) {
                s.setLength(s.length() - 1);
                hasVisited[neighbor] = false;
            }
        }

        return 3;
    }

    private static int[] getNeighbors(int i) {
        int[] ret = new int[10];
        for (int ii = 0; ii < ret.length; ii++) {
            ret[ii] = (i % 10) * 10 + ii;
        }

        return ret;
    }

    private static void test() {
        String sequence = getSequence();
        System.out.println(sequence);
        System.out.println(validSequence(sequence, 2));

        sequence = getSequence2();
        System.out.println(sequence);
        System.out.println(validSequence(sequence, 2));
    }

    public static boolean validSequence(String s, int length) {
        int l = s.length();
        s += s.substring(0, length);

        int[] integers = new int[l];
        for(int i = 0; i < l; i++) {
            integers[i] = Integer.parseInt(s.substring(i, i + length));
        }

        Arrays.sort(integers);

        for (int i = 0; i < l - 1; i++) {
            if (integers[i + 1] - integers[i] != 1) {
                System.out.println(integers[i] + " --> " + integers[i + 1]);
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        test();
    }
}
