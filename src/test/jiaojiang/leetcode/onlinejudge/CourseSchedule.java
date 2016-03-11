package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 8, 2016
 */
public class CourseSchedule {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[][].class);
            Test.assertTrue((Boolean) method.invoke(null, 2, new int[][]{{1, 0}}));
            Test.assertTrue((Boolean) method.invoke(null, 10, new int[][]{
                    {5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}}));

            Test.assertFalse((Boolean) method.invoke(null, 2, new int[][]{{1, 0}, {0, 1}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
