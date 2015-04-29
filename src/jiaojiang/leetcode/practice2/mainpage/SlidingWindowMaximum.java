package jiaojiang.leetcode.practice2.mainpage;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 26, 2014 10:43:22 PM
 */
public class SlidingWindowMaximum {
    /*
    A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
    The array is [1 3 -1 -3 5 3 6 7], and w is 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    Input: A long array A[], and a window width w
    Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
    Requirement: Find a good optimal way to get B[i]
     */
    public static int[] maxSlidingWindow(int A[], int w) {
        return null;
    }

    private static void test() {
        Utils.printArrayln(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public static void main(String[] args) {
        test();
    }
}
