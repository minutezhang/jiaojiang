package jiaojiang.leetcode.practice5.onlinejudge;

public class SetMismatch {
    /**
     * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some
     * error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one
     * number and loss of another number.
     * <p>
     * You are given an integer array nums representing the data status of this set after the error.
     * <p>
     * Find the number that occurs twice and the number that is missing and return them in the form of an array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,1]
     * Output: [1,2]
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 104
     * 1 <= nums[i] <= 104
     */
    public static int[] findErrorNums(int[] nums) {
//        int sum = Arrays.stream(nums).sum(), targetSum = nums.length * (nums.length + 1) / 2;
        int sum = 0, targetSum = nums.length * (nums.length + 1) / 2;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] < 0) {
                return new int[]{index, index + targetSum - sum};
            }
            nums[index - 1] = -nums[index - 1];
        }

        return new int[]{0, 0};
    }
}
