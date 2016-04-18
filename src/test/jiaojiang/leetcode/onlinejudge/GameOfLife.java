package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class GameOfLife {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            int[][] board = new int[][]{
                    {1, 1},
                    {1, 0}
            };

            method.invoke(null, (Object) board);
            Test.assertEquals(new int[][]{{1, 1}, {1, 1}}, board);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
