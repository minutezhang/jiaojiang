package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Random;

/**
 * @author: mizhang
 * @time: 3/6/15 11:21 AM
 */
public class ContainerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
    lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
    with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] < height[j]) {
                maxArea = Math.max((height[i] * (j - i)), maxArea);
                i++;
            } else {
                maxArea = Math.max((height[j] * (j - i)), maxArea);
                j--;
            }
        }

        return maxArea;
    }
}
