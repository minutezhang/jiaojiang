package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/17/15 3:52 PM
 */
public class SearchForARange {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(new int[]{3, 4}, (int[]) method.invoke(null, new int[]{5, 7, 7, 8, 8, 10}, 8));
            Test.assertEquals(new int[]{2, 5}, (int[]) method.invoke(null, new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
