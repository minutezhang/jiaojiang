package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 24, 2016
 */
public class PerfectSquare {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(3, method.invoke(null, 12));
            Test.assertEquals(2, method.invoke(null, 13));
            if (methodName.endsWith("Mem") || methodName.endsWith("Dp")) {
                Test.assertEquals(2, method.invoke(null, 61));
                Test.assertEquals(3, method.invoke(null, 62));
                Test.assertEquals(4, method.invoke(null, 63));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
