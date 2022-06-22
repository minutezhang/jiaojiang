package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    /**
     * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two
     * subsets such that the sum of elements in both subsets is equal.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(0);

        for (int n : nums) {
            for (int i : set1) {
                if (i + n == target) {
                    return true;
                }
                set2.add(i + n);
            }
            set1.addAll(set2);
            set2.clear();
        }
        return false;
    }

    private static boolean canParitionHelper(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length) {
            return false;
        }

        return canParitionHelper(nums, index + 1, target) || canParitionHelper(nums, index + 1, target - nums[index]);
    }
}
