package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 27, 2015 10:58:46 PM
 */
public class SearchA2DMatrix {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class, int.class);
            int[][] matrix = new int[][]{
                {1, 3, 5, 7}, 
                {10, 11, 16, 20}, 
                {23, 30, 34, 50}
            };
            Test.assertEquals(true, method.invoke(null, matrix, 3));
            Test.assertEquals(false, method.invoke(null, matrix, 13));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
