package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/30/15 9:35 PM
 */
public class FindPeakElement {
    /*
    A peak element is an element that is greater than its neighbors.

    Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    You may imagine that num[-1] = num[n] = -∞.

    For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    click to show spoilers.

    Note:
    Your solution should be in logarithmic complexity.

    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static int findPeakElement(int[] num) {
        int start = 0, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (mid < 1 || num[mid - 1] < num[mid]) {
                if (mid >= num.length - 1 || num[mid] > num[mid + 1]) {
                    return mid;
                }

                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
