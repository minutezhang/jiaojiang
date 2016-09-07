package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class GraphValidTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[][].class);
            Test.assertTrue((Boolean)method.invoke(null, 5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
            Test.assertFalse((Boolean)method.invoke(null, 5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
            Test.assertFalse((Boolean)method.invoke(null, 5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1,4}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
