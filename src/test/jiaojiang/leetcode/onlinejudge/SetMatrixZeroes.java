package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 27, 2015 11:09:14 PM
 */
public class SetMatrixZeroes {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            int[][] matrix = new int[][]{
                    {1, 2, 3, 4}, 
                    {5, 0, 5, 2}, 
                    {8, 9, 2, 0}, 
                    {5, 7, 2, 1}
            };

            int[][] expected = new int[][] {
                    {1, 0, 3, 0}, 
                    {0, 0, 0, 0}, 
                    {0, 0, 0, 0}, 
                    {5, 0, 2, 0}
            };

            method.invoke(null, (Object) matrix);
            Test.assertEquals(expected, matrix);

            matrix = new int[][]{{1}};
            expected = new int[][]{{1}};
            method.invoke(null, (Object) matrix);
            Test.assertEquals(expected, matrix);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
