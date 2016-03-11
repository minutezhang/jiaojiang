package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 3, 2016
 */
public class LongestIncreasingSubsequence {
    /*
     Given an unsorted array of integers, find the length of longest increasing subsequence.

    For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than
    one LIS combination, it is only necessary for you to return the length.

    Your algorithm should run in O(n2) complexity.

    Follow up: Could you improve it to O(n log n) time complexity?
     */
    public static int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] max = new int[nums.length];
//        int[] lengths = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            max[i] = nums[i];
//            lengths[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > max[j] && lengths[j] + 1 > lengths[i]) {
//                    lengths[i] = lengths[j] + 1;
//                    max[i] = nums[i];
//                } else if (nums[i] <= max[j] && lengths[j] > lengths[i]){
//                    lengths[i] = lengths[j];
//                    max[i] = max[j];
//                }
//            }
//        }

        int lengths[] = new int[nums.length];
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        return maxLength;
    }
}
