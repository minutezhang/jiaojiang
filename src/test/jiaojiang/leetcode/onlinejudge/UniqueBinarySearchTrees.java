package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 7:18 PM
 */
public class UniqueBinarySearchTrees {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 1));
            Test.assertEquals(2, method.invoke(null, 2));
            Test.assertEquals(5, method.invoke(null, 3));
            Test.assertEquals(14, method.invoke(null, 4));
            Test.assertEquals(42, method.invoke(null, 5));
            Test.assertEquals(132, method.invoke(null, 6));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
