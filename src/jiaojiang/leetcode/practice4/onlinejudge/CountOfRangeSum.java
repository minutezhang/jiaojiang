package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Apr 3, 2016
 */
public class CountOfRangeSum {
    /*
    Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
    Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ² j), inclusive.

    Note:
    A naive algorithm of O(n2) is trivial. You MUST do better than that.

    Example:
    Given nums = [-2, 5, -1], lower = -2, upper = 2,
    Return 3.
    The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
     */
    public static int countRangeSumNaive(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
    if current index is j, then next index is j + (j & -j)
    parent is j - (j & -j)
     */
    public static int countRangeSumBinaryIndexedTree(int[] nums, int lower, int upper) {
        int[] binaryIndexedTree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < binaryIndexedTree.length; j += (j & -j)) {
                binaryIndexedTree[j] += nums[i];
            }
        }

        

        return 0;
    }
}
