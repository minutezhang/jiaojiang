package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

/**
 * @author zhang
 *
 * Created on Mar 15, 2016
 */
public class SlidingWindowMaximum {
    /*
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    Therefore, return the max sliding window as [3,3,5,5,6,7].

    Note:
    You may assume k is always valid, ie: 1 � k � input array's size for non-empty array.

    Follow up:
    Could you solve it in linear time?

    Hint:

        How about using a data structure such as deque (double-ended queue)?
        The queue size need not be the same as the window�s size.
        Remove redundant elements and the queue should store only elements that need to be considered.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> windowIndices = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!windowIndices.isEmpty() && windowIndices.peekLast() - windowIndices.peekFirst() >= k - 1) {
                windowIndices.removeFirst();
            }
            for(;!windowIndices.isEmpty() && nums[windowIndices.peekLast()] <= nums[i]; windowIndices.removeLast());
            for(;!windowIndices.isEmpty() && nums[windowIndices.peekFirst()] <= nums[i]; windowIndices.removeFirst());
            windowIndices.addLast(i);
            if (i >= k - 1) {
                ret[i - k + 1] = nums[windowIndices.peekFirst()];
            }
        }

        return ret;
    }
}
