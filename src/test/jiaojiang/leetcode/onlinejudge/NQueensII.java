package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 22, 2015 7:54:23 PM
 */
public class NQueensII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 1));
            Test.assertEquals(0, method.invoke(null, 2));
            Test.assertEquals(0, method.invoke(null, 3));
            Test.assertEquals(2, method.invoke(null, 4));
            Test.assertEquals(10, method.invoke(null, 5));
            Test.assertEquals(4, method.invoke(null, 6));
            Test.assertEquals(40, method.invoke(null, 7));
            Test.assertEquals(92, method.invoke(null, 8));
            Test.assertEquals(352, method.invoke(null, 9));
            Test.assertEquals(724, method.invoke(null, 10));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
