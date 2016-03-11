package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class BulbSwitcher {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 3));
            Test.assertEquals(4, method.invoke(null, 16));
            Test.assertEquals(3162, method.invoke(null, 10000000));
            if (methodName.endsWith("2")) {
                Test.assertEquals(9999, method.invoke(null, 99999999));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
