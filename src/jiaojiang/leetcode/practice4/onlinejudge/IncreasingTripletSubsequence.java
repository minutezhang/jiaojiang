package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Feb 23, 2016
 */
public class IncreasingTripletSubsequence {
    /*
     Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

    Formally the function should:

        Return true if there exists i, j, k
        such that arr[i] < arr[j] < arr[k] given 0 ² i < j < k ² n-1 else return false.

    Your algorithm should run in O(n) time complexity and O(1) space complexity.

    Examples:
    Given [1, 2, 3, 4, 5],
    return true.

    Given [5, 4, 3, 2, 1],
    return false.
     */
    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i > min2) {
                return true;
            }

            if (i <= min) {
                min = i;
            } else if (i < min2) {
                min2 = i;
            }
        }

        return false;
    }
}
