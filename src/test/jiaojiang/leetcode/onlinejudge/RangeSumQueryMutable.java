package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 3, 2016
 */
public class RangeSumQueryMutable {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Class clazz = Class.forName(packageName + "." + className);
            Method method = clazz.getMethod(methodName, int.class, int.class);
            Object object = clazz.getConstructor(int[].class).newInstance(new int[]{1, 3, 5});
            Test.assertEquals(9, method.invoke(object, 0, 2));
            clazz.getMethod("update", int.class, int.class).invoke(object, 1, 2);
            Test.assertEquals(8, method.invoke(object, 0, 2));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
