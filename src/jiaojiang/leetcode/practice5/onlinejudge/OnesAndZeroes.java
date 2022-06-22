package jiaojiang.leetcode.practice5.onlinejudge;

public class OnesAndZeroes {
    /**
     * You are given an array of binary strings strs and two integers m and n.
     * <p>
     * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
     * <p>
     * A set x is a subset of a set y if all elements of x are also elements of y.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
     * Output: 4
     * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
     * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
     * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
     * <p>
     * Example 2:
     * <p>
     * Input: strs = ["10","0","1"], m = 1, n = 1
     * Output: 2
     * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= strs.length <= 600
     * 1 <= strs[i].length <= 100
     * strs[i] consists only of digits '0' and '1'.
     * 1 <= m, n <= 100
     */

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; --i) {
            int[] count = count(strs[i]);
            for (int j = m; j >= count[0]; --j) {
                for (int k = n; k >=count[1]; --k) {
                    counts[j][k] = Math.max(1 + counts[j - count[0]][k - count[1]], counts[j][k]);
                }
            }
        }

        return counts[m][n];
    }

    public static int findMaxFormMem(String[] strs, int m, int n) {
        int[][][] mem = new int[m + 1][n + 1][strs.length];
        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[0].length; ++j) {
                for (int k = 0; k < mem[0][0].length; ++k) {
                    mem[i][j][k] = -1;
                }
            }
        }
        return findMaxFormMem(strs, m, n, 0, mem);
    }

    public static int findMaxFormMem(String[] strs, int m, int n, int index, int[][][] mem) {
        if (index == strs.length) {
            return 0;
        }
        if (mem[m][n][index] != -1) {
            return mem[m][n][index];
        }

        int[] count = count(strs[index]);
        if (count[0] > m || count[1] > n) {
            mem[m][n][index] = findMaxFormMem(strs, m, n, index + 1, mem);
        } else {
            mem[m][n][index] = Math.max(1 + findMaxFormMem(strs, m - count[0], n - count[1], index + 1, mem), findMaxFormMem(strs, m, n, index + 1, mem));
        }
        return mem[m][n][index];
    }

    public static int findMaxForm2(String[] strs, int m, int n) {
        return findMaxFormRecursion(strs, m, n, 0);
    }

    public static int findMaxFormRecursion(String[] strs, int m, int n, int index) {
        if (index == strs.length) {
            return 0;
        }

        int[] count = count(strs[index]);
        if (count[0] > m || count[1] > n) {
            return findMaxFormRecursion(strs, m, n, index + 1);
        }

        return Math.max(1 + findMaxFormRecursion(strs, m - count[0], n - count[1], index + 1), findMaxFormRecursion(strs, m, n, index + 1));
    }

    private static int[] count(String s) {
        int[] ret = new int[]{0, 0};
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ++ret[0];
            } else if (c == '1') {
                ++ret[1];
            }
        }
        return ret;
    }
}
