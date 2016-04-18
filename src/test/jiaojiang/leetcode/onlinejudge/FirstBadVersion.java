package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 24, 2016
 */
public class FirstBadVersion {
   public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Class clazz = Class.forName(packageName + "." + className);
            Method method = clazz.getMethod(methodName, int.class);
            int expected = 8;
            Object object = clazz.getConstructor(int.class).newInstance(expected);
            Test.assertEquals(expected, method.invoke(object, 10));
            Test.assertEquals(expected, method.invoke(object, 40));
            Test.assertEquals(expected, method.invoke(object, 101));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
