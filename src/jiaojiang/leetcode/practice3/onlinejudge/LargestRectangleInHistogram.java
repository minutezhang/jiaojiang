package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Stack;

/**
 * @author: zhang
 * @date: Mar 5, 2015 10:11:54 PM
 */
public class LargestRectangleInHistogram {
    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the
    area of largest rectangle in the histogram.


    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.
     */
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> indices = new Stack<Integer>();
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            max = rollBack(height, indices, i, height[i], max);
            indices.add(i);
        }

        return rollBack(height, indices, height.length, 0, max);
    }

    private static int rollBack(int[] heights, Stack<Integer> indices, int currentIndex, int threshold, int currentMax) {
        while (!indices.isEmpty() && heights[indices.peek()] >= threshold) {
            int index = indices.pop();
            if (!indices.isEmpty()) {
                currentMax = Math.max(currentMax, (currentIndex - indices.peek() - 1) * heights[index]);
            } else {
                currentMax = Math.max(currentMax, currentIndex * heights[index]);
            }
        }

        return currentMax;
    }
}
