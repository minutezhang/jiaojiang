package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 2, 2016
 */
public class RangeSumQueryImmutable {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Class clazz = Class.forName(packageName + "." + className);
            Method method = clazz.getMethod(methodName, int.class, int.class);
            Object object = clazz.getConstructor(int[].class).newInstance(new int[]{-2, 0, 3, -5, 2, -1});
            Test.assertEquals(1, method.invoke(object, 0, 2));
            Test.assertEquals(-1, method.invoke(object, 2, 5));
            Test.assertEquals(-3, method.invoke(object, 0, 5));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
