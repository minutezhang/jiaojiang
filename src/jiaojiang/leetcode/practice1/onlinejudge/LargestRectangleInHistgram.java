package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Stack;

/**
 * @author: mizhang
 * @since: May 8, 2013 4:30:45 PM
 */
public class LargestRectangleInHistgram {
    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
    find the area of largest rectangle in the histogram.

    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.
     */

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] leftBoundary = new int[height.length];
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            leftBoundary[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }

        stack.clear();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            int right = stack.isEmpty() ? height.length - 1 : stack.peek() - 1;
            maxArea = Math.max(height[i] * (right - leftBoundary[i]), maxArea);
            stack.add(i);
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] height) {
         return largestRectangleArea(height, 0, height.length);
    }

    public static int largestRectangleArea(int[] height, int start, int end) {
        if (start == end - 1) {
            return height[start];
        }

        if (start >= end) {
            return 0;
        }

        int index = start, min = height[start];

        for (int i = start; i < end; i++) {
            if (height[i] < min) {
                index = i;
                min = height[i];
            }
        }

        return Math.max(min * (end - start), Math.max(largestRectangleArea(height, start, index), largestRectangleArea(height, index + 1, end))); 
    }

    public static void test() {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3})); //10
    }

    public static void main(String[] args) {
        test();
    }
}
