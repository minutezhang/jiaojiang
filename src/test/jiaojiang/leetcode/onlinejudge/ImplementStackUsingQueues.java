package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class ImplementStackUsingQueues {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            final Class clazz = Class.forName(packageName + "." + className);
            final Method method = clazz.getMethod(methodName);
            final Method pushMethod = clazz.getMethod("push", int.class);
            final Method popMethod = clazz.getMethod("pop");

            //////////// case 1 ////////////
            Object object = clazz.newInstance();
            pushMethod.invoke(object, 1);
            Test.assertEquals(1, method.invoke(object));
            pushMethod.invoke(object, 2);
            Test.assertEquals(2, method.invoke(object));
            pushMethod.invoke(object, 3);
            Test.assertEquals(3, method.invoke(object));
            pushMethod.invoke(object, 4);
            pushMethod.invoke(object, 5);
            Test.assertEquals(5, method.invoke(object));

            popMethod.invoke(object);
            Test.assertEquals(4, method.invoke(object));

            popMethod.invoke(object);
            Test.assertEquals(3, method.invoke(object));

            popMethod.invoke(object);
            Test.assertEquals(2, method.invoke(object));

            popMethod.invoke(object);
            Test.assertEquals(1, method.invoke(object));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
