package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class UglyNumberII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 1));
            Test.assertEquals(4, method.invoke(null, 4));
//            Test.assertEquals(6, method.invoke(null, 6));
//            Test.assertEquals(8, method.invoke(null, 7));
            Test.assertEquals(12, method.invoke(null, 10));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
