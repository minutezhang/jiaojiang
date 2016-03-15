package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class ImplementQueueUsingStacks {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
               //push(1),push(2),peek,pop,pop,empty
            final Class clazz = Class.forName(packageName + "." + className);
            final Method method = clazz.getMethod(methodName);
            final Method pushMethod = clazz.getMethod("push", int.class);
            final Method popMethod = clazz.getMethod("pop");
            final Method isEmptyMethod = clazz.getMethod("empty");

            //////////// case 1 ////////////
            Object object = clazz.newInstance();
            pushMethod.invoke(object, 1);
            Test.assertEquals(1, method.invoke(object));
            pushMethod.invoke(object, 2);
            Test.assertEquals(1, method.invoke(object));

            popMethod.invoke(object);
            Test.assertEquals(2, method.invoke(object));

            popMethod.invoke(object);

            Test.assertTrue((Boolean)isEmptyMethod.invoke(object));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
