package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/6/15 1:55 PM
 */
public class TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    For example, 
    Given [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], return 6.
     */
    public static int trap(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int[] rightMax = new int[A.length - 1];
        rightMax[rightMax.length - 1] = A[rightMax.length];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
        }

        int water = 0;
        for (int i = 0, leftMax = 0; i < rightMax.length; i++) {
            leftMax = Math.max(leftMax, A[i]);
            water += Math.max(Math.min(leftMax, rightMax[i]) - A[i], 0);
        }

        return water;

    }
}