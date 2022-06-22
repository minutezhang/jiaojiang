package jiaojiang.leetcode.practice5.onlinejudge;

public class TotalHammingDistance {
    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are
     * different.
     * <p>
     * Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,14,2]
     * Output: 6
     * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
     * showing the four bits relevant in this case).
     * The answer will be:
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [4,14,4]
     * Output: 4
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10^4
     * 0 <= nums[i] <= 10^9
     * The answer for the given input will fit in a 32-bit integer.
     */
    public static int totalHammingDistance(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 30; ++i) {
            int countOne = 0;
            for (int n : nums) {
                countOne += (n >> i) & 1;
            }
            ret += countOne * (nums.length - countOne);
        }
        return ret;
    }

    public static int totalHammingDistance2(int[] nums) {
        int ret = 0, mask = 1;
        for (int i = 0; i < 30; ++i, mask <<= 1) {
            int countOne = 0;
            for (int n : nums) {
                if ((n & mask) != 0) {
                    ++countOne;
                }
            }
            ret += countOne * (nums.length - countOne);
        }
        return ret;
    }

    public static int totalHammingDistance3(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                ret += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return ret;
    }
}