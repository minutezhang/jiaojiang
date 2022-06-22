package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class DiagonalTraverse {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            Test.assertEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, (int[])method.invoke(null, (Object) new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
            Test.assertEquals(new int[]{1, 2, 3, 4}, (int[])method.invoke(null, (Object) new int[][]{{1, 2}, {3, 4}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
