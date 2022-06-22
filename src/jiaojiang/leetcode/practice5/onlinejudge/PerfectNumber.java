package jiaojiang.leetcode.practice5.onlinejudge;

public class PerfectNumber {
    /**
     * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number
     * itself. A divisor of an integer x is an integer that can divide x evenly.
     * <p>
     * Given an integer n, return true if n is a perfect number, otherwise return false.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: num = 28
     * Output: true
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     * 1, 2, 4, 7, and 14 are all divisors of 28.
     * <p>
     * Example 2:
     * <p>
     * Input: num = 7
     * Output: false
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= num <= 10^8
     */
    public static boolean checkPerfectNumber(int num) {
        int end = (int) Math.sqrt(num);
        int sum = 0;
        for (int i = 1; i <= end; ++i) {
            if (num % i == 0) {
                if (i != num) {
                    sum += i;
                }
                if (i != 1) {
                    sum += num / i;
                }
                if (sum > num) {
                    return false;
                }
            }
        }
        return sum == num;
    }
}
