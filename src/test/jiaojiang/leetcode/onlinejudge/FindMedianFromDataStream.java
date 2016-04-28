package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhang
 *
 * Created on Apr 22, 2016
 */
public class FindMedianFromDataStream {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        test(new int[] {1, 3, 11, 6, 8}, new double[]{1.0, 2.0, 3.0, 4.5, 6.0});
        test(new int[] {6, 10, 2, 6, 5, 0, 6, 3, 1, 0, 0}, new double[]{6.0, 8.0, 6.0, 6.0, 6.0, 5.5, 6.0, 5.5, 5.0, 4.0, 3.0});
    }

    private static void test(int[] nums, double[] expectedMedian) {
        jiaojiang.leetcode.practice4.onlinejudge.FindMedianFromDataStream medianFinder
                = new jiaojiang.leetcode.practice4.onlinejudge.FindMedianFromDataStream();
        for (int i = 0; i < nums.length; i++) {
            medianFinder.addNum(nums[i]);
            Test.assertEquals(expectedMedian[i], medianFinder.findMedian());
        }

    }
}
