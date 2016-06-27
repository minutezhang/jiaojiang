package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Jun 21, 2016
 */
public class CourseScheduleII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[][].class);
            Test.assertEquals(new int[] {0, 1}, (int[])method.invoke(null, 2, new int[][]{{1, 0}}));
            Test.assertEquals(new int[0], (int[])method.invoke(null, 2, new int[][]{{1, 0}, {0, 1}}));
            Test.assertEquals(new int[0], (int[])method.invoke(null, 4, new int[][]{{0,1}, {3, 1}, {1, 3}, {3, 2}}));
            Test.assertEquals(new int[]{0,1, 2, 3}, (int[])method.invoke(null, 4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
