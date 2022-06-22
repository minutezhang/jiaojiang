package jiaojiang.leetcode.practice5.onlinejudge;

import com.sun.security.jgss.GSSUtil;
import utils.Utils;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    /**
     * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
     *
     * In one move, you can increment or decrement an element of the array by 1.
     *
     * Test cases are designed so that the answer will fit in a 32-bit integer.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: 2
     * Explanation:
     * Only two moves are needed (remember each move increments or decrements one element):
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     *
     * Example 2:
     *
     * Input: nums = [1,10,2,9]
     * Output: 16
     *
     *
     *
     * Constraints:
     *
     *     n == nums.length
     *     1 <= nums.length <= 10^5
     *     -10^9 <= nums[i] <= 10^9
     */
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            long dis = right[i] - left[i] + (2 * i + 1 - nums.length) * (long)nums[i];
            System.out.println(i + "," + dis);
            min = Math.min(min, dis);
        }

        return (int)min;
    }

    public static int minMoves2Median(int[] nums) {
        int median = nOrder(nums, 0, nums.length, (nums.length + 1) / 2);
        int min = 0;
        for (int i : nums) {
            min += Math.abs(i - median);
        }
        return min;
    }

    // pivot is always nums[end - 1]
    private static int nOrder(int[] nums, int start, int end, int n) {
        if (start == end - 1) {
            return nums[start];
        }
        // this randomization pivot is very important, which reduced the total runtime in leetcode from 147ms to 2ms
        // partially because the test cases in leetcode is ordered and cause the run time close to worst case O(n^2)
        int pivotIndex = (int)(start + Math.random() * (end - start));
        swap(nums, pivotIndex, end - 1);
        int index = start;
        for (int i = start; i < end - 1; ++i) {
            if (nums[i] < nums[end - 1]) {
                swap(nums, i, index);
                ++index;
            }
        }
        if (index - start == n - 1) {
            return nums[end - 1];
        }
        if (index - start < n) {
            return nOrder(nums, index, end - 1, n - (index - start) - 1);
        }
        return nOrder(nums, start, index, n);
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static int minMoves2Median2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length >> 1];
        int min = 0;
        for (int i : nums) {
            min += Math.abs(i - median);
        }

        return min;
    }
}
