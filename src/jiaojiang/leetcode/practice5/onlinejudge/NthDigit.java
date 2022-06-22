package jiaojiang.leetcode.practice5.onlinejudge;

public class NthDigit {
    /**
     * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
     * ...].
     * <p>
     * Example 1:
     * <p>
     * Input: n = 3
     * Output: 3
     * <p>
     * Example 2:
     * <p>
     * Input: n = 11
     * Output: 0
     * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the
     * number 10.
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 2^31 - 1
     */
    public static int findNthDigit(int n) {
        int[] segments = new int[9], bases = new int[9];
        bases[0] = 1;
        for (int i = 1; i < segments.length; ++i) {
            bases[i] = bases[i - 1] * 10;
            segments[i] = i * 9 * bases[i - 1];
        }

        int index;
        for (index = 0; index < 9 && n >= segments[index]; n -= segments[index++]);
        if (n == 0) {
            return 9;
        }
        int k = (n - 1) / index + bases[index - 1], l = (index - n % index) % index;
        for (int i = 0; i < l; ++i) {
            k /= 10;
        }
        return k % 10;
    }
}