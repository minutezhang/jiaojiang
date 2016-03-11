package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 * 
 * Created on Mar 6, 2016
 */
public class MoveZeroes {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);

            int[] inputs = new int[]{0, 1, 0, 3, 12};
            int[] expected = new int[]{1, 3, 12, 0, 0};
            method.invoke(null, (Object)inputs);
            Test.assertEquals(expected, inputs);

            inputs = new int[]{1};
            expected = new int[]{1};
            method.invoke(null, (Object)inputs);
            Test.assertEquals(expected, inputs);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
