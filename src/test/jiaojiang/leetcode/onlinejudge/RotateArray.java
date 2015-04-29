package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 25, 2015 11:01:09 PM
 */
public class RotateArray {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
            int[] expected = new int[]{5, 6, 7, 1, 2, 3, 4};
            method.invoke(null, nums, 3);
            Test.assertEquals(expected, nums);

            nums = new int[]{-1};
            expected = new int[]{-1};
            method.invoke(null, nums, 2);
            Test.assertEquals(expected, nums);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
