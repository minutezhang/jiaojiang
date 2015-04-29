package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Apr 16, 2013 1:54:11 PM
 */
public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
        For example, 
        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    public static int trap(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int[] leftHeight = new int[A.length];
        leftHeight[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            leftHeight[i] = A[i] > leftHeight[i - 1] ? A[i] : leftHeight[i - 1];
        }

        int area = 0, rightHeight = A[A.length - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > rightHeight) {
                rightHeight = A[i];
            }
            int height = rightHeight > leftHeight[i] ? leftHeight[i] : rightHeight;
            area += height - A[i];
        }

        return area;
    }

    public static void test() {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static void main(String[] args) {
        test();
    }
}
