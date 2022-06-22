package jiaojiang.leetcode.practice5.onlinejudge;

public class ThirdMaximumNumber {
    /**
     * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum
     * does not exist, return the maximum number.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [2,2,3,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
     * The third distinct maximum is 1.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -2^31 <= nums[i] <= 2^31 - 1
     * <p>
     * <p>
     * Follow up: Can you find an O(n) solution?
     */
    public static int thirdMax(int[] nums) {
        long[] buf = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int i : nums) {
            if (i == buf[0] || i == buf[1] || i == buf[2]) {
                continue;
            }
            if (i > buf[2]) {
                buf[2] = i;
                if (i > buf[1]) {
                    buf[2] = buf[1];
                    buf[1] = i;
                    if (i > buf[0]) {
                        buf[1] = buf[0];
                        buf[0] = i;
                    }
                }
            }
        }
        return buf[2] == Long.MIN_VALUE ? (int) buf[0] : (int) buf[2];
    }
}
