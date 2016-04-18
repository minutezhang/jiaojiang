package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Set;
import java.util.HashSet;

/**
 * @author zhang
 *
 * Created on Mar 24, 2016
 */
public class PerfectSquare {
    /*
    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which
    sum to n.

    For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
     */
    public static int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= sqrt; i++) {
            min = Math.min(min, numSquares(n - i * i));
        }

        return 1 + min;
    }

    public static int numSquaresMem(int n) {
        int[] mem = new int[n];

        return numSquaresMemHelp(n, mem);
    }

    private static int numSquaresMemHelp(int n, int[] mem) {
        if (mem[n - 1] != 0) {
            return mem[n - 1];
        }

        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return mem[n - 1] = 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= sqrt; i++) {
            min = Math.min(min, numSquaresMemHelp(n - i * i, mem));
        }
        mem[n - 1] = 1 + min;

        return mem[n - 1];
    }



    public static int numSquaresDp(int n) {
        Set<Integer>[] sets = new HashSet[]{new HashSet<Integer>(), new HashSet<Integer>()};

        int i = 1;
        sets[i & 1].add(0);

        while (!sets[i & 1].contains(n)) {
            sets[(i + 1) & 1].clear();
            for (int number : sets[ i & 1]) {
                for (int ii = 1; number + ii * ii <= n; ii++) {
                    if (number + ii * ii == n) {
                        return i;
                    }
                    sets[(i + 1) & 1].add(number + ii * ii);
                }
            }
            i++;
        }

        return 0;
    }
}
