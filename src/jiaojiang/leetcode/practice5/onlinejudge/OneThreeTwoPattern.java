package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class OneThreeTwoPattern {
    /**
     * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
     * such that i < j < k and nums[i] < nums[k] < nums[j].
     * <p>
     * Return true if there is a 132 pattern in nums, otherwise, return false.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: false
     * Explanation: There is no 132 pattern in the sequence.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [3,1,4,2]
     * Output: true
     * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [-1,3,2,0]
     * Output: true
     * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 2 * 10^5
     * -10^9 <= nums[i] <= 10^9
     */
    public static boolean find132Pattern(int[] nums) {
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        TreeSet<Integer> list = new TreeSet<>();

        for (int i = nums.length - 1; i > 0; --i) {
            Integer lower = list.lower(nums[i]);
            if (list.lower(nums[i]) != null && lower > mins[i] ) {
                return true;
            }
            list.add(nums[i]);
        }
        return false;
    }
}